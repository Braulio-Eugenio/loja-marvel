package br.com.zup.pgg.lojamarvel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.zup.pgg.lojamarvel.entity.Cliente;

public class ClienteService {
	private static Map<String, Cliente> listaClientes;

	public Cliente adicionaCliente(Cliente cliente) {

		return listaClientes.put(cliente.getCpf(), cliente);
	}

	public List<Cliente> buscaCliente(String cpf) {
		List<Cliente> listaCliente = new ArrayList(listaClientes.values());

		if (cpf != null) {
			
		
		}
		
		return  listaCliente;

	}

	public static void buscaListaDeClientes() {
		for (Cliente cliente : listaClientes.values()) {
			clienteBuscado(cliente);

		}

	}

	public static void alteraCadastro(String cpf, Cliente cliente) {

		Cliente clienteAlterado = listaClientes.get(cpf);

		listaClientes.put(cpf, cliente);
		clienteBuscado(cliente);
	}

	public static void excluirCadastro(String cpf) {

		listaClientes.remove(cpf);
	}

	public static void clienteBuscado(Cliente clienteBuscado) {

	}

}
