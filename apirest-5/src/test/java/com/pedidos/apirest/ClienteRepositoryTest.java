package com.pedidos.apirest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pedidos.apirest.models.Cliente;
import com.pedidos.apirest.repositories.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ClienteRepositoryTest {
	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	public void Salvar() throws Exception {

		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setCodigo(1L);
		cliente.setEndereco("Pernanbuco");

		Cliente cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setCodigo(1L);
		cliente2.setEndereco("Pernanbuco");

		this.clienteRepository.save(cliente);

		// Cliente
		assertThat(cliente).isEqualTo(cliente2);
	}

	@Test
	public void Pesquisar() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setCodigo(1L);
		cliente.setEndereco("Pernanbuco");

		Cliente cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setCodigo(1L);
		cliente2.setEndereco("Pernanbuco");

		this.clienteRepository.save(cliente);

		Cliente cliente3 = new Cliente();
		cliente3 = this.clienteRepository.findOne(cliente2.getId());

	}
}
