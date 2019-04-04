package br.com.db1.pedidos.pedidosapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;

public interface PedidoRepository extends CrudRepository<Produto, Long>{
	Produto findBycodigo(String codigo);
}
