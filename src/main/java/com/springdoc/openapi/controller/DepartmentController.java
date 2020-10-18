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

import com.springdoc.openapi.model.DepartmentModel;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Department API", description = "It will provide all operations for Department")
@RestController
@RequestMapping(path = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<?> delete(@PathVariable int departmentId) {
		DepartmentModel department = new DepartmentModel();
		department.setId(departmentId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentModel> getAll(@PathVariable int departmentId) {
		DepartmentModel department = new DepartmentModel();
		department.setId(departmentId);
		return ResponseEntity.ok(department);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentModel>> getAll() {
		List<DepartmentModel> departments = Arrays.asList(new DepartmentModel(), new DepartmentModel());
		return ResponseEntity.ok(departments);
	}

	@PostMapping
	public ResponseEntity<DepartmentModel> save(DepartmentModel department) {
		return new ResponseEntity<DepartmentModel>(department, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<DepartmentModel> update(DepartmentModel department) {
		return ResponseEntity.ok(department);
	}

}
