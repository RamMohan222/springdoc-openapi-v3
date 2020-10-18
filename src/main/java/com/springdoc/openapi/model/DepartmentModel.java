package com.springdoc.openapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentModel extends CommonModel {
	private int id;
	private String name;
	private String code;
	private EmployeeModel deptHead;
}
