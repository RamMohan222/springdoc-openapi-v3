package com.springdoc.openapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdoc.openapi.model.EmployeeModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee API", description = "It will provide all operations for Employee")
@RestController
@RequestMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> delete(@PathVariable int employeeId) {
		return ResponseEntity.accepted().build();
	}

	@Operation(summary = "Get The Employee Details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the employee", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeModel.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Employee Id", content = @Content),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content) })
	@GetMapping("/{employeeId}")
	public EmployeeModel get(@PathVariable String employeeId) {
		EmployeeModel employee = new EmployeeModel();
		employee.setEmployeeId(employeeId);
		return employee;
	}

	@GetMapping
	public ResponseEntity<List<EmployeeModel>> getAll() {
		List<EmployeeModel> employees = Arrays.asList(new EmployeeModel(), new EmployeeModel());
		return ResponseEntity.ok(employees);
	}

	@PostMapping
	public ResponseEntity<EmployeeModel> save(EmployeeModel employee) {
		employee = new EmployeeModel();
		employee.setEmployeeId("EMP01");
		return new ResponseEntity<EmployeeModel>(employee, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<EmployeeModel> update(EmployeeModel employee) {
		employee = new EmployeeModel();
		return ResponseEntity.ok(employee);
	}

}
