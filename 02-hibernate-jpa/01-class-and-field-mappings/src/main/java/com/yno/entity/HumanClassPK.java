package com.yno.entity;

import java.io.Serializable;

import lombok.Data;

@Data

public class HumanClassPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String phone;
	private String email;

}
