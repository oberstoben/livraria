package com.ufabc.web.livraria.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ufabc.web.livraria.model.dao.ClienteDao;
import com.ufabc.web.livraria.model.dao.EmprestimoDao;
import com.ufabc.web.livraria.model.dao.ExemplarDao;
import com.ufabc.web.livraria.model.entity.Cliente;
import com.ufabc.web.livraria.model.entity.Emprestimo;

@Controller
public class EmprestimoController {

	@Autowired
	ClienteDao clienteDao;
	@Autowired
	ExemplarDao exemplarDao;
	@Autowired
	EmprestimoDao emprestimoDao;
	
	@RequestMapping(value = {"/emprestimos"})
	@ResponseBody
	//pagina para listar exemplares
	public ModelAndView exemplares() {
		ModelAndView mv = new ModelAndView("emprestimos");
		mv.addObject("emprestimos", emprestimoDao.findAll());
		System.out.println(emprestimoDao.findAll().toString());
		return mv;
	}
	
	
	// pagina que insere exemplar
	@RequestMapping(value = {"/alugarExemplar/{id}" })
	@ResponseBody
	public ModelAndView inserirExemplar(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("alugarExemplar");
		
		mv.addObject(exemplarDao.getReferenceById(id));
		
		return mv;
	}

	// Paginas com forms
	@RequestMapping(value = { "/salvarEmprestimo" })
	@ResponseBody
	public RedirectView salvarEmprestimo(@RequestParam Long idexemplar, @RequestParam String cliente,@RequestParam Date dataDeRetorno, @RequestParam Date dataDeEmprestimo) 
	{
		Cliente cliente2 = new Cliente();
		cliente2 = clienteDao.findByNome(cliente);
		Emprestimo emprestimo = new Emprestimo(cliente2, exemplarDao.getReferenceById(idexemplar), dataDeEmprestimo, dataDeRetorno);
		
		emprestimoDao.save(emprestimo);
		
		return new RedirectView("/exemplares");
	}
	
	
}
