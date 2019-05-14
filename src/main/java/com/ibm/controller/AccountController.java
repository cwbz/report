package com.ibm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.ibm.entity.Account;
import com.ibm.mapper.AccountMapper;
import com.ibm.vo.AccountVo;
import com.ibm.vo.mapper.AccountDtoMapper;

@Controller
public class AccountController extends BaseController {
	
	@Autowired
	private AccountMapper accountMapper;
	
    @RequestMapping(value="/example")
    public String example(Model model){
    	List<Account> accountList = accountMapper.getAll();
    	Map<String,Integer> tjMap = new HashMap<String,Integer>();
    	String keyStr="";
    	for(Account account : accountList){
    		if(account.getEmail().indexOf("@123.com")!=-1){
    			keyStr="emai:l123"; 
    		}else if(account.getEmail().indexOf("@sohu.com")!=-1){
    			keyStr="emai:sohu";
    		}else if(account.getEmail().indexOf("@qq.com")!=-1){
    			keyStr="emai:qq";
    		}else if(account.getEmail().indexOf("@yahoo.com.cn")!=-1){
    			keyStr="emai:yahoo";
    		}else if(account.getEmail().indexOf("@0355.net")!=-1){
    			keyStr="emai:0355";
    		}else if(account.getEmail().indexOf("@hotmail.com")!=-1){
    			keyStr="emai:hotmail";
    		}else if(account.getEmail().indexOf("@163.net")!=-1){
    			keyStr="emai:163";
    		}else if(account.getEmail().indexOf("@yeah.net")!=-1){
    			keyStr="emai:yeah";
    		}else if(account.getEmail().indexOf("@live.com")!=-1){
    			keyStr="emai:live";
    		}else if(account.getEmail().indexOf("@gmail.com")!=-1){
    			keyStr="emai:gmail";
    		}else if(account.getEmail().indexOf("@3721.net")!=-1){
    			keyStr="emai:3721";
    		}else if(account.getEmail().indexOf("@sina.com")!=-1){
    			keyStr="emai:sina";
    		}else if(account.getEmail().indexOf("@msn.com")!=-1){
    			keyStr="emai:msn";
    		}else{
    			keyStr="other";
    		}
    		if(tjMap.containsKey(keyStr)){
    			tjMap.put(keyStr, tjMap.get(keyStr)+1);
    		}else{
    			tjMap.put(keyStr, 1);	
    		}
    	}
    	model.addAttribute("tjMap", JSON.toJSON(tjMap));
    	model.addAttribute("accountList", accountList);
    	return "/index";
    }
    
    @RequestMapping(value="/example2")
    public String example2(Model model){
    	List<Account> accountList = accountMapper.getAll();
    	Map<String,Integer> tjMap = new HashMap<String,Integer>();
    	String keyStr="";
    	for(Account account : accountList){
    		if(account.getEmail().indexOf("@123.com")!=-1){
    			keyStr="emai:l123";
    		}else if(account.getEmail().indexOf("@sohu.com")!=-1){
    			keyStr="emai:sohu";
    		}else if(account.getEmail().indexOf("@qq.com")!=-1){
    			keyStr="emai:qq";
    		}else if(account.getEmail().indexOf("@yahoo.com.cn")!=-1){
    			keyStr="emai:yahoo";
    		}else if(account.getEmail().indexOf("@0355.net")!=-1){
    			keyStr="emai:0355";
    		}else if(account.getEmail().indexOf("@hotmail.com")!=-1){
    			keyStr="emai:hotmail";
    		}else if(account.getEmail().indexOf("@163.net")!=-1){
    			keyStr="emai:163";
    		}else if(account.getEmail().indexOf("@yeah.net")!=-1){
    			keyStr="emai:yeah";
    		}else if(account.getEmail().indexOf("@live.com")!=-1){
    			keyStr="emai:live";
    		}else if(account.getEmail().indexOf("@gmail.com")!=-1){
    			keyStr="emai:gmail";
    		}else if(account.getEmail().indexOf("@3721.net")!=-1){
    			keyStr="emai:3721";
    		}else if(account.getEmail().indexOf("@sina.com")!=-1){
    			keyStr="emai:sina";
    		}else if(account.getEmail().indexOf("@msn.com")!=-1){
    			keyStr="emai:msn";
    		}else{
    			keyStr="other";
    		}
    		if(tjMap.containsKey(keyStr)){
    			tjMap.put(keyStr, tjMap.get(keyStr)+1);
    		}else{ 
    			tjMap.put(keyStr, 1);	
    		}
    	}
    	
    	 StringBuffer buffer = new StringBuffer();
    	 for (Map.Entry<String, Integer> entry : tjMap.entrySet()) {
    		 	if(null != buffer && buffer.length() > 0){
    		 		buffer.append(",");
	 	    	}else{
	 	    		buffer.append("[");   	    		
	 	    	}
	 	    	buffer.append("{name: '" + entry.getKey() +" ', value: " + entry.getValue() + "}");
    	 }
    	 buffer.append("]");
    	model.addAttribute("tjMap", JSON.toJSON(buffer.toString()));
    	model.addAttribute("accountList", accountList);
    	return "/index2";
    }

    @RequestMapping(value="/example3")
    public String example3(Model model){
    	List<Account> accountList = accountMapper.getAll();
    	model.addAttribute("accountList", accountList);
    	/*   转换一个对象 	
    	 * 		Account account = new Account();
    			AccountVo accountVo = AccountDtoMapper.INSTANCE.accountToAccountVo(account);*/
    	List<AccountVo> accountVoList = AccountDtoMapper.INSTANCE.accountsToAccountVos(accountList);
    	model.addAttribute("accountVoList", accountVoList);
    	return "/index3";
    }
}
