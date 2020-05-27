package br.com.zup.pgg.lojamarvel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.zup.pgg.lojamarvel.entity.Cliente;

public class ClienteService {
	private static Map<String, Cliente> listaClientes = new HashMap<String, Cliente>();

	public Cliente adicionaCliente(Cliente cliente) {

		return listaClientes.put(cliente.getCpf(), cliente);
	}

	public List<Cliente> buscaCliente(String cpf) {

		if (cpf != null) {
			List<Cliente> listaCliente = new ArrayList();
			listaCliente.add(listaClientes.get(cpf));
			return listaCliente;
		} else {

			List<Cliente> listaCliente = new ArrayList(listaClientes.values());
			return listaCliente;
		}

	}

	public Cliente alteraCadastro(String cpf, Cliente cliente) {

		Cliente clienteAlterado = listaClientes.get(cpf);
		listaClientes.put(cpf, cliente);

		return clienteAlterado;

	}

	public  void excluirCadastro(String cpf) {

		listaClientes.remove(cpf);
	}

}
