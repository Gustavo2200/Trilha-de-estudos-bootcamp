package one.digitalinnovation.gof.service;

import java.util.List;

import one.digitalinnovation.gof.model.Cliente;

public interface ClienteServiceTODO {

		List<Cliente> buscarTodos();

		Cliente buscarPorId(Long id);

		void inserir(Cliente cliente);

		void atualizar(Long id, Cliente cliente);

		void deletar(Long id);
}
