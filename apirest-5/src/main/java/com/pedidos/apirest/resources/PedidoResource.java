package com.pedidos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.apirest.models.Pedidos;
import com.pedidos.apirest.models.Produto;
import com.pedidos.apirest.repositories.ClienteRepository;
import com.pedidos.apirest.repositories.PedidoRepository;
import com.pedidos.apirest.repositories.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
public class PedidoResource {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/Pedido")
	public List<Pedidos> Listar() {
		return pedidoRepository.findAll();
	}

	@PostMapping("/Pedido")
	public Pedidos SalvarPedidos(@RequestBody Pedidos pedido) {

		for (Produto item : pedido.getCodigosProdutos()) {
			produtoRepository.saveAndFlush(item);
		}

		clienteRepository.saveAndFlush(pedido.getCodigoCliente());

		return pedidoRepository.saveAndFlush(pedido);
	}

}
