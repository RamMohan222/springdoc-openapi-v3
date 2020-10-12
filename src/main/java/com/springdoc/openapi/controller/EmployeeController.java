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

import com.springdoc.openapi.model.CommonModel;
import com.springdoc.openapi.model.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@GetMapping
	public ResponseEntity<List<Employee>> get() {
		List<Employee> employees = Arrays.asList(new Employee(), new Employee());
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/common")
	public ResponseEntity<List<Employee>> get(CommonModel common) {
		List<Employee> employees = Arrays.asList(new Employee(), new Employee());
		return ResponseEntity.ok(employees);
	}

	@Operation(summary = "Get The Employee Details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the employee", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid Employee Id", content = @Content),
			@ApiResponse(responseCode = "404", description = "Employee not found", content = @Content) })
	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> get(@PathVariable String employeeId) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		return ResponseEntity.ok(employee);
	}

	@PostMapping
	public ResponseEntity<Employee> save(Employee employee) {
		employee = new Employee();
		employee.setEmployeeId("EMP01");
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Employee> update(Employee employee) {
		employee = new Employee();
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Employee> delete(@PathVariable int employeeId) {
		return ResponseEntity.accepted().build();
	}
}
