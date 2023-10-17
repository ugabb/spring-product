package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path="/calculadora")
public class CalculadoraController {
	
	// /calculadora/somar/10/20
	// /calculadora/subtrair?a=100&b=50
	
	@GetMapping()
	public String calculadora() {
		return "/calculadora works!";
	}
	
	@GetMapping(path="/somar/{a}/{b}")
	public int somar(@PathVariable int a, @PathVariable int b) {
		return a + b ;
	}
	
	@GetMapping(path="/subtrair")
	public int subtrair(@RequestParam(name="a") int a, @RequestParam(name="b") int b) {
		return a - b;
	}

}
