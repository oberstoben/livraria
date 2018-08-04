package com.ufabc.web.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ufabc.web.livraria.model.dao.AutorDao;
import com.ufabc.web.livraria.model.entity.Autor;

@Controller
public class AutorController {
	@Autowired
	AutorDao autorDao;
	
	//pagina que lista os autores 
	@RequestMapping(value = { "/autores" })
	@ResponseBody
	public ModelAndView autores() {
		ModelAndView mv = new ModelAndView("autores");
		mv.addObject("autores", autorDao.findAll());
		return mv;
	}	
	
	//redirecionar para p�gina de inserir autor
	@RequestMapping(value = { "/inserirAutor" })
	@ResponseBody
	public ModelAndView inserirAutor() {
		ModelAndView mv = new ModelAndView("inserirAutor");
		return mv;
	}

	//redirecionar para p�gina de editar autor
	@RequestMapping(value = { "/editarAutor/{id}" })
	public ModelAndView editarAutor(@PathVariable Long id) {
		Autor autor = autorDao.getOne(id);
		
		ModelAndView mv = new ModelAndView("editarAutor");			
		mv.addObject("autor",autor);
		return mv;
	}
	
	// remover autor	
	@RequestMapping(value = { "/removerAutor/{id}" })
	public RedirectView removerAutor(@PathVariable Long id) {
		Autor autor = autorDao.getOne(id);		
		autorDao.delete(autor);			
		return new RedirectView("/autores");
	}
	
		
	//Paginas com forms	
		
	@RequestMapping(value = { "/salvarAutor" })
	@ResponseBody
	public RedirectView salvar(@RequestParam String nomeAutor, @RequestParam String nacionalidadeAutor) {
		
		Autor autor = new Autor();

		autor.setNome(nomeAutor);
		autor.setNacionalidade(nacionalidadeAutor);			
		autorDao.save(autor);
		return new RedirectView("/autores");
	}
	
	@RequestMapping(value = { "/salvarEdicaoAutor" })
	@ResponseBody
	public RedirectView salvarEdicaoAutor(@RequestParam String id, @RequestParam String nome, @RequestParam String nacionalidade) {		
		Autor autor = new Autor();
		
		autorDao.getOne(Long.parseLong(id));		
		autor.setNome(nome);
		autor.setNacionalidade(nacionalidade);			
		
		autorDao.save(autor);							
		return new RedirectView("/autores");
	}
	
	
}