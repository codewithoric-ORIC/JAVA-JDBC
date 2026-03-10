package com.yno;

public class User {
	
	private int id;
	private String name;
	private Gender gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (null != name) {
			
		}
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public enum Gender {
		MALE, FEMALE, OTHER
	}	

}
