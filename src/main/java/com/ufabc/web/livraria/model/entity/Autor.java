package com.ufabc.web.livraria.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
	@SequenceGenerator(name = "service_sequence", sequenceName = "service_sequence", allocationSize=1)
	private Long idautor;
	private String nome;
	private String nacionalidade;
	
	public Long getIdautor() {
		return idautor;
	}
	public void setIdautor(Long id) {
		this.idautor = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
