package com.pedidos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.apirest.models.Cliente;
import com.pedidos.apirest.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/Cliente")
	public List<Cliente> Listar() {
		return clienteRepository.findAll();
	}
 
	@PostMapping("/Cliente")
	public Cliente SalvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}
