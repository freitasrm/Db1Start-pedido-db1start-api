package br.com.db1.pedidos.pedidosapi.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;

public class ProdutoDTO implements Serializable{
	
	public static final long serialVersionUID = 23L;

	private Long id;
	private Double valor;
	private String nome;
	private String codigo;
	private ProdutoStatus status;

	public ProdutoDTO(Long id, String codigo, String nome, Double valor, ProdutoStatus status) {
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.status = status;
	}
	
	public ProdutoDTO() {
	}

	public Double getValor() {
		return valor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setStatus(ProdutoStatus status) {
		this.status = status;
	}

	public ProdutoStatus getStatus() {
		return status;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nome, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProdutoDTO)) {
			return false;
		}
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome)
				&& Objects.equals(valor, other.valor);
	}
	
}
