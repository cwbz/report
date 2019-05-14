package com.ibm.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@TableId(type=IdType.AUTO)
	private Long id;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 密码
	 */
	private String passWord;	
	
	/**
	 * 盐
	 */
	private String salt;
	
	/**
	 * 是否锁定
	 */
	@TableField(value = "is_locked")
	private boolean locked;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 邮箱
	 */
	private String email;
		
	/**
	 * 是否是管理员
	 */
	@TableField(value = "is_admin")
	private boolean admin;
	
	/**
	 * 是否可用
	 */
	private boolean available;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	@TableField(value = "gmt_create")
	private Date  createTime;	
	
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	@TableField(value = "gmt_modified")
	private Date  modifiedTime;	
	
}
