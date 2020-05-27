package br.com.zup.pgg.lojamarvel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.zup.pgg.lojamarvel.dao.ClienteDao;
import br.com.zup.pgg.lojamarvel.entity.Cliente;

public class ClienteService {
	ClienteDao clienteDao = new ClienteDao();

	public Cliente adicionaCliente(Cliente cliente) {
		clienteDao.insereCliente(cliente);

		return cliente;
	}

	public List<Cliente> buscaCliente(String cpf) {

		if (cpf != null) {
			List<Cliente> listaCliente = new ArrayList();
			listaCliente.add(clienteDao.listaClientesPorCpf(cpf));
			return listaCliente;
		} else {

			return clienteDao.listaClientes();
		}

	}

	public Cliente alteraCadastro(String cpf, Cliente cliente) {

		clienteDao.alteraCliente(cliente, cpf);

		return cliente;

	}

	public void excluirCadastro(String cpf) {

		clienteDao.deletaCliente(cpf);
	}

}
