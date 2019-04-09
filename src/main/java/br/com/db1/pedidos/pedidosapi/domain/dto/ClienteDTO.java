package br.com.db1.pedidos.pedidosapi.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;

public class ClienteDTO implements Serializable{
	
	public static final long serialVersionUID = 23L;

	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private ClienteStatus status;

	public ClienteDTO(Long id, String nome, String cpf, ClienteStatus status) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.status = status;
	}
	
	public ClienteDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ClienteStatus getStatus() {
		return status;
	}

	public void setStatus(ClienteStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ClienteDTO)) {
			return false;
		}
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(cpf, other.cpf);
	}
	
}
