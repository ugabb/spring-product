package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {
	
	@GetMapping
	public String get() {
		return "GET";
	}
	
	@PostMapping
	public String post() {
		return "POST";
	}
	
	@DeleteMapping
	public String delete() {
		return "DELETE";
	}
	
	@PutMapping
	public String put() {
		return "PUT";
	}
	
	@PatchMapping
	public String patch() {
		return "PATCH";
	}
}
