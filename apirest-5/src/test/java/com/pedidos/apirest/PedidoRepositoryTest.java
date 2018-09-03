package com.pedidos.apirest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pedidos.apirest.models.Cliente;
import com.pedidos.apirest.models.Pedidos;
import com.pedidos.apirest.models.Produto;
import com.pedidos.apirest.repositories.ClienteRepository;
import com.pedidos.apirest.repositories.PedidoRepository;
import com.pedidos.apirest.repositories.ProdutoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PedidoRepositoryTest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	public void Salvar() throws Exception {

		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setCodigo(1L);
		cliente.setEndereco("Teste");

		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigo(1L);
		produto.setNome("teste");
		produto.setPreco(20.00);

		Pedidos pedido = new Pedidos();
		pedido.setCodigoCliente(cliente);
		pedido.setCodigosProdutos(Arrays.asList(produto));
		pedido.setValorTotal(200.00);

		Cliente cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setCodigo(1L);
		cliente2.setEndereco("Teste");

		Produto produto2 = new Produto();
		produto2.setId(1L);
		produto2.setCodigo(1L);
		produto2.setNome("teste");
		produto2.setPreco(20.00);
		
		this.pedidoRepository.save(pedido);
		this.produtoRepository.save(produto);
		this.clienteRepository.save(cliente);

		// Pedido
		assertThat(pedido.getValorTotal()).isEqualTo(200.00);

		// Cliente
		assertThat(pedido.getCodigoCliente()).isEqualTo(cliente2);

		// Produto
		
		for (Produto item : pedido.getCodigosProdutos()) {  assertThat(item).isEqualTo(produto2); }
		
	}

	@Test
	public void Pesquisar() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setCodigo(1L);
		cliente.setEndereco("Teste");

		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigo(1L);
		produto.setNome("teste");
		produto.setPreco(20.00);

		Pedidos pedido = new Pedidos();
		pedido.setId(1L);
		pedido.setCodigoCliente(cliente);
		pedido.setCodigosProdutos(Arrays.asList(produto));
		pedido.setValorTotal(200.00);

		Cliente cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setCodigo(1L);
		cliente2.setEndereco("Teste");

		Produto produto2 = new Produto();
		produto2.setId(1L);
		produto2.setCodigo(1L);
		produto2.setNome("teste");
		produto2.setPreco(20.00);

		Pedidos pedido2 = new Pedidos();
		pedido2.setId(1L);
		pedido2.setCodigoCliente(cliente2);
		pedido2.setCodigosProdutos(Arrays.asList(produto2));
		pedido2.setValorTotal(200.00);

		this.pedidoRepository.save(pedido);
		this.produtoRepository.save(produto);
		this.clienteRepository.save(cliente);

		Pedidos pedido3 = new Pedidos();
		pedido3 = this.pedidoRepository.findOne(pedido2.getId());

		Cliente cliente3 = new Cliente();
		cliente3 = this.clienteRepository.findOne(cliente2.getId());

		Produto produto3 = new Produto();
		produto3 = this.produtoRepository.findOne(produto2.getId());
	}
}
