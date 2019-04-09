package br.com.db1.pedidos.pedidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

//	List<ProdutoDTO> produtos = new ArrayList<>();
	
	public List<ProdutoDTO> getAllActive(){
		return this.getByStatus(ProdutoStatus.ATIVO);
	}
	
	public List<ProdutoDTO> getByStatus(ProdutoStatus status){
		return produtoRepository.findByStatus(status)
				.stream()
				.map(produto -> this.produtoToDTO(produto))
				.collect(Collectors.toList());		
		
	}
	
	public ProdutoDTO salvar(ProdutoDTO dto) {
		Produto produto = new Produto(dto.getCodigo(),dto.getNome(),dto.getValor());
		Produto produtoSalvo = produtoRepository.save(produto);
		return this.produtoToDTO(produtoSalvo);
	}
	
	private ProdutoDTO produtoToDTO(Produto produto) {
		return new ProdutoDTO(produto.getId(), produto.getCodigo(), produto.getNome(), produto.getValor(), produto.getStatus());
	}

}
