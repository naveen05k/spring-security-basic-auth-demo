package com.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getAllEmployees() {
		return "You Received All Employees List";
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveEmployees() {
		return "You saved a Employee";
	}

	@PutMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String updateEmployees() {
		return "You updated a Employee";
	}
}