package br.com.db1.pedidos.pedidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Cliente;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;
import br.com.db1.pedidos.pedidosapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<ClienteDTO> getAllActive(){
		return this.getByStatus(ClienteStatus.ATIVO);		
	}
	
	public List<ClienteDTO> getByStatus(ClienteStatus status){
		return clienteRepository.findByStatus(status)
				.stream()
				.map(cliente -> this.clienteToDTO(cliente))
				.collect(Collectors.toList());		
		
	}
	
	public ClienteDTO salvar(ClienteDTO dto) {
		Cliente cliente = new Cliente(dto.getNome(),dto.getCpf());
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return this.clienteToDTO(clienteSalvo);
	}
	
	private ClienteDTO clienteToDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getStatus());
	}

	public ClienteDTO alterar(Long id, ClienteDTO body) {
		try {
			Cliente clienteDataBase = clienteRepository.getOne(id);
			clienteDataBase.setNome(body.getNome());
			clienteDataBase.setCpf(body.getCpf());
			clienteRepository.save(clienteDataBase);
			return this.clienteToDTO(clienteDataBase);
		}catch (ConstraintViolationException e) {
			throw new RuntimeException("CPF Duplicado");
		}
	}
	
	public ClienteDTO deletar(Long id) {
		Cliente clienteDataBase = clienteRepository.getOne(id);
		clienteRepository.delete(clienteDataBase);
		return this.clienteToDTO(clienteDataBase);
	}
}
