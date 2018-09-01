package com.pedidos.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedidos.apirest.models.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	
}
