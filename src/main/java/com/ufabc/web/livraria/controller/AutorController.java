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
	
	@RequestMapping(value = { "/autores/findByName/" })
	@ResponseBody
	public List<Autor> autoresFindByName(@RequestParam String autor) {
		return autorDao.findByNomeContainingIgnoreCase(autor);
	}
	
	@RequestMapping(value = { "/autores/findAll" })
	@ResponseBody
	public List<Autor> autoresFindAll() {
		return autorDao.findAll();
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
		Autor autor = autorDao.getReferenceById(id);
		
		ModelAndView mv = new ModelAndView("editarAutor");			
		mv.addObject("autor",autor);
		return mv;
	}
	
	// remover autor	
	@RequestMapping(value = { "/removerAutor/{id}" })
	public RedirectView removerAutor(@PathVariable Long id) {
		Autor autor = autorDao.getReferenceById(id);		
		autorDao.delete(autor);			
		return new RedirectView("/autores");
	}
	
		
	//Paginas com forms	
		
	@RequestMapping(value = { "/salvarAutor" })
	@ResponseBody
	public ModelAndView salvar(@ModelAttribute Autor autor) {		
		
		
		autorDao.save(autor);
		
		
		return new ModelAndView("redirect:/autores");
	}
	
	@RequestMapping(value = { "/salvarEdicaoAutor" })
	@ResponseBody
	public RedirectView salvarEdicaoAutor(@ModelAttribute Autor autor) {		
		
		autorDao.save(autor);
		
		return new RedirectView("/autores");
	}
	
	
}
