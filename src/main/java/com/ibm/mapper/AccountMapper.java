package com.ibm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibm.entity.Account;


public interface AccountMapper extends BaseMapper<Account> {
	@Cacheable(value = "customSelect" ,key = "targetClass + methodName +#p0")
	@Select("select id,user_name,pass_word,salt,is_locked as locked,mobile,email,is_admin as admin,available,gmt_create as createTime,gmt_modified as modifiedTime from account")
	List<Account> getAll();
}
