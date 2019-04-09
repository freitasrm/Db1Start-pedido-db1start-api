package br.com.db1.pedidos.pedidosapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.db1.pedidos.pedidosapi.infraestrutura.Verificador;

@Table(name="cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome",length = 50, nullable = false)
	private String nome;
	
	@Column(name = "cpf", length = 11,nullable = false,unique = true)
	private String cpf;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 30, nullable = false)
	private ClienteStatus status;
	
	protected Cliente() {}

	public Cliente(String nome, String cpf) {
		Verificador.naoNulo(nome, "nome do cliente");
		Verificador.naoNulo(cpf, "CPF do cliente");
		Verificador.cpf(cpf);
		
		this.nome = nome;
		this.cpf= cpf;
		this.status = ClienteStatus.ATIVO;
	}
	
	public void setCpf(String cpf) {
		Verificador.naoNulo(cpf, "CPF do cliente");
		Verificador.cpf(cpf);
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		Verificador.naoNulo(nome, "nome do cliente");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public ClienteStatus getStatus() {
		return status;
	}
	
	public void inativar() {
		if (!this.isAtivo()) {
			throw new RuntimeException("Produto está " + this.status);
		}
		this.status = ClienteStatus.INATIVO;
	}
	
	public boolean isAtivo() {
		return ClienteStatus.ATIVO.equals(this.status);
	}
}