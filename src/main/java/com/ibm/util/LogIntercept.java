package com.ibm.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * @author : 任丽鹏
 * @ClassName : LogIntercept
 * @ModifiedBy : 任丽鹏
 * @date : 2019年4月16日 下午4:00:28 
 */
@Aspect
@Component
public class LogIntercept {
	private static final String AOP_POINTCUT_EXPRESSION="execution(* com.ibm..*.*(..))";
    @Pointcut(value=AOP_POINTCUT_EXPRESSION)    
    public void recordLog(){}
    
    @Around("recordLog()")
    public Object  around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result = null;
        StringBuilder sbLog = new StringBuilder("\n");
        try {
            sbLog.append(String.format("类名：%s\r\n", proceedingJoinPoint.getTarget().getClass().getName()));

            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            sbLog.append(String.format("方法：%s\r\n", methodSignature.getMethod().getName()));

            Object[] args = proceedingJoinPoint.getArgs();
            for (Object o : args) {
                sbLog.append(String.format("参数：%s\r\n", JSON.toJSON(o)));
            }

            long startTime = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            sbLog.append(String.format("返回：%s\r\n", JSON.toJSON(result)));
            sbLog.append(String.format("耗时：%ss", endTime - startTime));
        } catch (Exception ex) {
            sbLog.append(String.format("异常：%s", ex.getMessage()));
        } finally {
            System.out.println(sbLog.toString());
        }
        return result;
    }

}
