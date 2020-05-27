package br.com.zup.pgg.lojamarvel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.zup.pgg.lojamarvel.entity.Cliente;
import br.com.zup.pgg.lojamarvel.service.ClienteService;

@WebServlet(urlPatterns = "/clientes")
public class ControllerCliente extends HttpServlet {
	private static final String CATACTERE_POSICAO_INICIAL = "/";
	private static final int ACRESCENTA_UMA_POSICAO = 1;
	private static final long serialVersionUID = 1L;
	ClienteService clienteService = new ClienteService();
	Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = req.getReader().lines().collect(Collectors.joining());
		Cliente clienteRequest = gson.fromJson(json, Cliente.class);
		Cliente clienteResposnse = clienteService.adicionaCliente(clienteRequest);
		String clienteJson = gson.toJson(clienteResposnse);
		PrintWriter out = resp.getWriter();
		out.print(clienteJson);
		out.flush();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf");
		List<Cliente> listaDeCliente = clienteService.buscaCliente(cpf);
		String clienteJson = gson.toJson(listaDeCliente);
		PrintWriter out = resp.getWriter();
		out.print(listaDeCliente);
		out.flush();

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf(CATACTERE_POSICAO_INICIAL);
		String cpf = uri.substring(indexParam + ACRESCENTA_UMA_POSICAO);
		
		String json = req.getReader().lines().collect(Collectors.joining());
		Cliente clienteRequest = gson.fromJson(json, Cliente.class);
		Cliente clienteResposnse = clienteService.alteraCadastro(cpf, clienteRequest);
		
		String clienteJson = gson.toJson(clienteResposnse);
		PrintWriter out = resp.getWriter();
		out.print(clienteJson);
		out.flush();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		int indexParam = uri.lastIndexOf(CATACTERE_POSICAO_INICIAL);
		String cpf = uri.substring(indexParam + ACRESCENTA_UMA_POSICAO);
		clienteService.excluirCadastro(cpf);
	}
}
