package com.ufabc.web.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ufabc.web.livraria.model.dao.AutorDao;
import com.ufabc.web.livraria.model.dao.ExemplarDao;
import com.ufabc.web.livraria.model.dao.LivroDao;
import com.ufabc.web.livraria.model.entity.Livro;

@Controller
public class LivroController {

	@Autowired
	LivroDao livroDao;
	@Autowired
	AutorDao autorDao;
	@Autowired
	ExemplarDao exemplarDao;

	@RequestMapping(value = {"/", "/index"})
	@ResponseBody
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("livros", livroDao.findAll());
		System.out.println(autorDao.findAll().toString());
		
		return mv;
	}
	
	
	// pagina que lista os livros
	@RequestMapping(value = {"/livros" })
	@ResponseBody
	public ModelAndView livros() {		
		
		ModelAndView mv = new ModelAndView("livros");
		mv.addObject("livros", livroDao.findAll());
		System.out.println(autorDao.findAll().toString());
		return mv;
	}

	// redirecionar para pagina de inserir livro
	@RequestMapping(value = { "/inserirLivro" })
	@ResponseBody
	public ModelAndView inserirLivro() {
		ModelAndView mv = new ModelAndView("inserirLivro");
		
		mv.addObject("autores", autorDao.findAll());
		
		return mv;
	}

	// redirecionar para pagina de editar livro
	@RequestMapping(value = { "/editarLivro/{id}" })
	public ModelAndView editarLivro(@PathVariable Long id) {		
		ModelAndView mv = new ModelAndView("editarLivro");
		Livro livro = new Livro();
		livro  = livroDao.getReferenceById(id);
		mv.addObject("livro", livro);
		mv.addObject("autores",autorDao.findAll());
		
		
		return mv;
	}

	// remover livro
	@RequestMapping(value = { "/removerLivro/{id}" })
	public RedirectView removerLivro(@PathVariable Long id) {
		Livro livro = livroDao.getReferenceById(id);
		livroDao.delete(livro);
		return new RedirectView("/livros");
	}

	// Paginas com forms

	@RequestMapping(value = { "/salvarLivro" })
	@ResponseBody
	public RedirectView salvarLivro(@RequestParam String titulo, @RequestParam int edicao,
			@RequestParam int ano, @RequestParam String idioma,
			@RequestParam String isbn, @RequestParam String srcImagemCapa, @RequestParam String autor) 
	{
		Livro livro = new Livro(titulo, edicao, ano, idioma, isbn, srcImagemCapa);
		livro.setAutor(autorDao.findByNome(autor));
		livroDao.save(livro);

		return new RedirectView("/livros");

	}

	@RequestMapping(value = { "/salvarEdicaoLivro" })
	@ResponseBody
	public RedirectView salvarEdicaoLivro(@ModelAttribute Livro livro) {
		
		livroDao.save(livro);				
		return new RedirectView("/livros");
	}
	@RequestMapping(value = { "/livros/findByName/" })
	@ResponseBody
	public List<Livro> livrosFindByName(@RequestParam String titulo) {
		System.out.println(titulo);
		return livroDao.findByTituloContainingIgnoreCase(titulo);
	}

}
