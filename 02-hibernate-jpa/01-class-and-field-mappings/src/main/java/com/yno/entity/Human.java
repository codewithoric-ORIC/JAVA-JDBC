package com.yno.entity;

import java.io.Serializable;

//import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "human_tbl")
@IdClass(HumanClassPK.class)
public class Human implements Serializable{
	
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private HumanPK idPk;
	private String name;
	
	@Id
	private String phone;
	@Id
	private String email;

}
