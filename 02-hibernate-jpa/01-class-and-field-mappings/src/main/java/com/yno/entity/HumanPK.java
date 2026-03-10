package com.yno.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class HumanPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String phone;
	private String email;

}
