package one.digitalinnovation.gof.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
@Service
public class ClienteService implements ClienteServiceTODO {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ViaCepService viaCepService;
	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> todosClientes = (List<Cliente>) clienteRepository.findAll();
		if(!todosClientes.isEmpty()) {
			return todosClientes;
		}
			return Collections.emptyList();	
		
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> clienteOp = clienteRepository.findById(id);
		if(clienteOp.isPresent()) {
			Cliente cliente = clienteOp.get();
			return cliente;
		}
		return null;
	}

	@Override
	public void inserir(Cliente cliente) {
		 try {
		        String cep = cliente.getEndereco().getCep();
		        Endereco endereco = viaCepService.consultarCep(cep);

		        if (endereco != null) {
//		        	boolean enderecoExste = false;
//		        	for(Endereco e : enderecoRepository.findAll()) {
//		        		if(endereco.getCep().equals(e.getCep())) {
//		        			enderecoExste = true;
//		        		}
//		        	}
//		        	if(!enderecoExste) {
//		        	enderecoRepository.save(endereco);
//		        	}
		            cliente.setEndereco(endereco);
		            clienteRepository.save(cliente);
		        } else {
		            System.out.println("Erro ao obter o endereço do ViaCep para o CEP: " + cep);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.println("Erro ao inserir cliente: " + e.getMessage());
		    }
		
	}
	public Endereco localizarEnderecoCep(String cep) {
		Endereco endereco = viaCepService.consultarCep(cep);
		return endereco;
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		for(Cliente c : clienteRepository.findAll()) {
			if(c.getId()== id) {
				c.setId(cliente.getId());
				c.setNome(cliente.getNome());
				Endereco endereco = viaCepService.consultarCep(cliente.getEndereco().getCep());
				c.setEndereco(endereco);
				clienteRepository.save(c);
			}
		}
		
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
