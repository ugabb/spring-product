package com.example.springboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import models.Cliente;

@RestController
@RequestMapping(path="/clientes")
public class ClienteController {
	
	@GetMapping(path="/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28,"Gabriel", "081.543.768.90");
	}
	
	@GetMapping("/{id}")
	public Cliente ObterClienteporId1(@PathVariable int id) {
		return new Cliente(id, "Naruto","892.932.932.09");
	}
	
	@GetMapping
	public Cliente ObterClienteporId2(@RequestParam(name="id",defaultValue = "1", required = true) int id) {
		return new Cliente(id, "Sasuke","123.932.232.09");
	}
}
