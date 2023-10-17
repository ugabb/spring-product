package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping(path = { "/ola", "/saudacao" })
	public String ola() {
		return "Hello SpringBoot!";
	}

	@PostMapping(path =  "/saudacao" )
	public String saudacao() {
		return "Hello SpringBoot! (POST)";
	}
}
