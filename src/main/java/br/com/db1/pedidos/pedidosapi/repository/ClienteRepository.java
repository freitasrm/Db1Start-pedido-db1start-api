package br.com.db1.pedidos.pedidosapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
	Cliente findBycpf(String cpf);
	

}
