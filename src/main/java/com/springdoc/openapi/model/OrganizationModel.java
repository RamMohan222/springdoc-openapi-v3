package com.springdoc.openapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
//@Schema(title = "Organization", description = "These are all the basic organization details")
@Schema(description = "These are all the basic organization details")
public class OrganizationModel extends CommonModel {
	@Schema(description = "oranization unique identifier")
	private int id;
	@Schema(description = "Oranization Name")
	private String name;
	@Schema(description = "Oranization Url")
	private String url;
	@Schema(description = "Oranization Logo url")
	private String logo;
	@Schema(description = "Oranization Address Details")
	private String address;
}
