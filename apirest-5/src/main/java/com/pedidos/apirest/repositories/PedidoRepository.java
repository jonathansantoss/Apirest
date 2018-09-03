package com.pedidos.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.apirest.models.Pedidos;

@Repository
public interface PedidoRepository extends JpaRepository<Pedidos, Long>{
	
	
}
