package com.springdoc.openapi.model;

import java.util.Date;

import lombok.Data;

@Data
public class CommonModel {

	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modfiedBy;
	
}
