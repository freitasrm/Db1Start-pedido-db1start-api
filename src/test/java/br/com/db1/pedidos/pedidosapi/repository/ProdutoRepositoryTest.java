package br.com.db1.pedidos.pedidosapi.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoRepositoryTest 	{
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Before
	public void after() {
		produtoRepository.deleteAll();
	}
	
	
	@Test
	public void deveSalvarUmProduto() {
		Produto produto = new Produto("123","Produto Teste",10.0);
		
		produtoRepository.save(produto);
		
		long count = produtoRepository.count();
		
		Assert.assertEquals(1, count,0);
		
	}
	
	@Test
	public void deveSalvarProdutoAlterado() {
		Produto produto = new Produto("123","Produto Teste",10.0);
		
		produtoRepository.save(produto);
		
		Produto produtoSalvo = produtoRepository.findBycodigo("123");
		
		produtoSalvo.inativar();
		
		produtoRepository.save(produtoSalvo);
		
		Produto produtoAlterado = produtoRepository.findBycodigo("123");
		
		Assert.assertEquals(ProdutoStatus.INATIVO,produtoAlterado.getStatus());
		
	}

}
