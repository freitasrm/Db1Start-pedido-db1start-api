package br.com.db1.pedidos.pedidosapi.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.repository.PedidoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoRepositoryTest {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Before
	public void after() {
		pedidoRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmPedido() {
		Cliente cliente = new Cliente("Rodrigo Martins","38909498862");
		Produto produto = new Produto("123","ABC",3.3);
	}

}