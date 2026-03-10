package com.yno.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter
@Embeddable
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	
	private String religion;
	private String hobbie;
	private String description;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(description, hobbie, religion);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		return Objects.equals(description, other.description) && Objects.equals(hobbie, other.hobbie)
				&& Objects.equals(religion, other.religion);
	}
	
	

}
