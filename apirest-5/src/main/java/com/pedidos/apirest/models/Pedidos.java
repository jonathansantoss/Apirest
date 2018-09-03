package com.pedidos.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDOS")
public class Pedidos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente codigoCliente;

	@ManyToMany
	@JoinTable(name = "PEDIDO_PRODUTO", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produto> codigosProdutos;

	private Double valorTotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Cliente codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public List<Produto> getCodigosProdutos() {
		return codigosProdutos;
	}

	public void setCodigosProdutos(List<Produto> codigosProdutos) {
		this.codigosProdutos = codigosProdutos;
	}
	
	public Pedidos() { }
	
	public Pedidos(Long id, Cliente codigoCliente, List<Produto> codigosProdutos, Double valorTotal) {
		super();
		this.id = id;
		this.codigoCliente = codigoCliente;
		this.codigosProdutos = codigosProdutos;
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
		result = prime * result + ((codigosProdutos == null) ? 0 : codigosProdutos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		if (codigoCliente == null) {
			if (other.codigoCliente != null)
				return false;
		} else if (!codigoCliente.equals(other.codigoCliente))
			return false;
		if (codigosProdutos == null) {
			if (other.codigosProdutos != null)
				return false;
		} else if (!codigosProdutos.equals(other.codigosProdutos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

}