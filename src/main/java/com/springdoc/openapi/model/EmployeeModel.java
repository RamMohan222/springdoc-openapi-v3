package com.springdoc.openapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeModel extends CommonModel {

	private String employeeId;
	private String firstName;
	private String lastName;
	private long salary;
	private DepartmentModel department;

}
