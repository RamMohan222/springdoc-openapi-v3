package com.springdoc.openapi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdoc.openapi.model.CommonModel;
import com.springdoc.openapi.model.OrganizationModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Organization API", description = "It will provide all operations for Oranization")
@RestController
@RequestMapping(path = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {

	@Operation(summary = "Organization information", description = "It will return organization information")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the organization information", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = OrganizationModel.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Request", content = @Content(mediaType = "application/json")),
			@ApiResponse(responseCode = "404", description = "Organization not found", content = @Content(mediaType = "application/json")) })
	@GetMapping
	public ResponseEntity<OrganizationModel> get() {
		OrganizationModel organization = new OrganizationModel();
		return ResponseEntity.ok(organization);
	}

	@Operation(summary = "Just for testing")
	@GetMapping("/common")
	public ResponseEntity<CommonModel> get(CommonModel common) {
		return ResponseEntity.ok(common);
	}
}
