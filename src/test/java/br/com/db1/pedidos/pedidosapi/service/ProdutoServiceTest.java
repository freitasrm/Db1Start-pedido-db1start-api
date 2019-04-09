package br.com.db1.pedidos.pedidosapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoServiceTest 	{
	
	@MockBean
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Test
	public void deveriaRetornarTodosOsProdutos() {
		List<Produto> value = Arrays.asList(new Produto("A","A",10.0));
		BDDMockito.when(produtoRepository.findAll()).thenReturn(value);
		
		List<ProdutoDTO> expected = new ArrayList<ProdutoDTO>();
		expected.add(new ProdutoDTO((long)1,"A","A",10.0,ProdutoStatus.ATIVO));
		
		List<ProdutoDTO> actual = produtoService.getAllActive();
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void deveRetornarListaVaziaQuandoNaoExistemProdutos() {
		BDDMockito.when(produtoRepository.findAll()).thenReturn(null);
		
		List<ProdutoDTO> expected = new ArrayList<ProdutoDTO>();
		List<ProdutoDTO> actual = produtoService.getAllActive();

		Assert.assertEquals(expected, actual);
	}
	
}
