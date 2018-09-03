package com.pedidos.apirest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pedidos.apirest.models.Produto;
import com.pedidos.apirest.repositories.ProdutoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	public void Salvar() throws Exception {

		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigo(1L);
		produto.setNome("teste");
		produto.setPreco(20.00);

		Produto produto2 = new Produto();
		produto2.setId(1L);
		produto2.setCodigo(1L);
		produto2.setNome("teste");
		produto2.setPreco(20.00);

		this.produtoRepository.save(produto);

		// produto
		assertThat(produto).isEqualTo(produto2);
	}
	
	@Test
	public void Pesquisar() throws Exception {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigo(1L);
		produto.setNome("teste");
		produto.setPreco(20.00);

		Produto produto2 = new Produto();
		produto2.setId(1L);
		produto2.setCodigo(1L);
		produto2.setNome("teste");
		produto2.setPreco(20.00);

		this.produtoRepository.save(produto);
		
		Produto produto3 = new Produto();
		produto3 = this.produtoRepository.findOne(produto2.getId());
	}
}
