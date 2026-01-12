package com.ufabc.web.livraria.model.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
	@SequenceGenerator(name = "service_sequence", sequenceName = "service_sequence", allocationSize=1)
	private Long ideditora;
	private String nome;
	private String sede;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Livro> livros = new ArrayList<Livro>();
	
	public Collection<Livro> getLivros() {
		return livros;
	}
	public void setLivros(Collection<Livro> livros) {
		this.livros = livros;
	}
	public Long getIdeditora() {
		return ideditora;
	}
	public void setIdeditora(Long id) {
		this.ideditora = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
}
