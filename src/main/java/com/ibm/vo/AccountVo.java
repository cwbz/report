package com.ibm.vo;

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
public class AccountVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;	
	private String salt;
	private boolean locked;
	private String mobile;
	private String email;
	private boolean admin;
	private boolean available;
	private Date  createTime;	
	private Date  modifiedTime;	
	private String email2;
	private String userName2;
	
}
