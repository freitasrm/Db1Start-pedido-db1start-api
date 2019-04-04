package br.com.db1.pedidos.pedidosapi.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;
import br.com.db1.pedidos.pedidosapi.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest 	{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Before
	public void after() {
		clienteRepository.deleteAll();
	}
	
	
	@Test
	public void deveSalvarUmCliente() {
		Cliente cliente = new Cliente("Rodrigo Martins","38909498862");
		
		clienteRepository.save(cliente);
		
		long count = clienteRepository.count();
		
		Assert.assertEquals(1, count,0);
		
	}
	
	@Test
	public void deveSalvarClienteAlterado() {
		Cliente produto = new Cliente("Rodrigo Martins","38909498862");
		
		clienteRepository.save(produto);
		
		Cliente clienteSalvo = clienteRepository.findBycpf("38909498862");
		
		clienteSalvo.inativar();
		
		clienteRepository.save(clienteSalvo);
		
		Cliente produtoAlterado = clienteRepository.findBycpf("38909498862");
		
		Assert.assertEquals(ClienteStatus.INATIVO,produtoAlterado.getStatus());
		
	}

}
