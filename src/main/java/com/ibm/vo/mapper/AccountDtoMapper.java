package com.ibm.vo.mapper;

import com.ibm.entity.Account;
import com.ibm.vo.AccountVo;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface AccountDtoMapper {
	AccountDtoMapper INSTANCE = Mappers.getMapper( AccountDtoMapper.class ); 
	/**
	 * entity 转 vo
	 * 备注：只有属性名不一样的才需要单独写出来
	 * @Mapping 属性转关可以写多个例如
	 * @Mapping(source = "email", target = "email2")
	 * @Mapping(source = "userName", target = "userName2")
	 */
	@Mapping(source = "email", target = "email2")
	AccountVo accountToAccountVo(Account account);
	
	
	@Mappings({
		 @Mapping( source = "email", target = "email2"),
	     @Mapping( source = "userName", target = "userName2")
	})
	AccountVo accountToAccountVo2(Account account);
	
	/**
	 * 属性名相同会自动映射转换
	 * 此时 accountsToAccountVos 的实现为循环调用 accountToAccountVo 并继承了 studentToUser 的属性映射
	 * @param accountList
	 * @return
	 */
	List<AccountVo> accountsToAccountVos(List<Account> accountList);
}
