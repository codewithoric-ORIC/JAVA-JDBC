package com.yno;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AnimalInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String food;
	private String ability;
	private String description;
	
}
