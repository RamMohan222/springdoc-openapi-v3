package com.springdoc.openapi.model;

import lombok.Data;

@Data
public class Employee extends CommonModel {

	private String employeeId;
	private String firstName;
	private String lastName;
	private long salary;
	
}
