package com.ufabc.web.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ufabc.web.livraria.model.dao.ClienteDao;
import com.ufabc.web.livraria.model.entity.Cliente;


@Controller
public class ClienteController {

	@Autowired
	ClienteDao clienteDao;

	// pagina que lista os clientes
	@RequestMapping(value = { "/clientes" })
	@ResponseBody
	public ModelAndView clientes() {
		ModelAndView mv = new ModelAndView("clientes");
		mv.addObject("clientes", clienteDao.findAll());
		return mv;
	}

	// redirecionar para pagina de inserir autor
	@RequestMapping(value = { "/inserirCliente" })
	@ResponseBody
	public ModelAndView inserirCliente() {
		ModelAndView mv = new ModelAndView("inserirCliente");
		return mv;
	}

	// redirecionar para pagina de editar cliente
	@RequestMapping(value = { "/editarCliente/{id}" })
	public ModelAndView editarCliente(@PathVariable Long id) {
		Cliente cliente = clienteDao.getReferenceById(id);

		ModelAndView mv = new ModelAndView("editarCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	// remover autor
	@RequestMapping(value = { "/removerCliente/{id}" })
	public RedirectView removerCliente(@PathVariable Long id) {
		Cliente cliente = clienteDao.getReferenceById(id);
		clienteDao.delete(cliente);
		return new RedirectView("/clientes");
	}

	// Paginas com forms

	@RequestMapping(value = { "/salvarCliente" })
	@ResponseBody
	public RedirectView salvarCliente(@RequestParam String nome, @RequestParam String cpf,
			@RequestParam String idade, @RequestParam String endereco, @RequestParam String email) {

		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setIdade(Integer.parseInt(idade));
		cliente.setEndereco(endereco);
		cliente.setEmail(email);

		clienteDao.save(cliente);
		return new RedirectView("/clientes");
	}

	@RequestMapping(value = { "/salvarEdicaoCliente" })
	@ResponseBody
	public RedirectView salvarEdicaoCliente(@RequestParam String id, @RequestParam String nome, @RequestParam String cpf,
			@RequestParam String idade, @RequestParam String endereco, @RequestParam String email) {
		Cliente cliente = new Cliente();

		cliente = clienteDao.getReferenceById(Long.parseLong(id));

		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setIdade(Integer.parseInt(idade));
		cliente.setEndereco(endereco);
		cliente.setEmail(email);
		
		clienteDao.save(cliente);
		
		return new RedirectView("/clientes");
	}
	
	@RequestMapping(value = { "/cliente/findByName/" })
	@ResponseBody
	public List<Cliente> clienteFindByName(@RequestParam String nome) {
		return clienteDao.findByNomeContainingIgnoreCase(nome);
	}
}