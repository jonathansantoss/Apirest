package com.pedidos.apirest.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.apirest.models.Produto;
import com.pedidos.apirest.repositories.ProdutoRepository;



@RestController
@RequestMapping(value ="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/Produtos")
	public List<Produto> Listar() {
		return  produtoRepository.findAll();
	}
	
	@PostMapping("/Produtos")
	public Produto SalvarProduto(@RequestBody Produto produtos) {
		return produtoRepository.save(produtos);
	}
}
