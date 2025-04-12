package com.springsecurity.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

	@GetMapping("/home")
	public String handleHomeScreen() {
		return "Welcome";
	}

	@GetMapping("/user/home")
	public String handleUserScreen() {
		return "user";
	}

	@GetMapping("/admin/home")
	public String handleAdminScreen() {
		return "admin";
	}

}
