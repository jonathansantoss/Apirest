package com.pedidos.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidos.apirest.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long > {

}
