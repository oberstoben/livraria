package com.ufabc.web.livraria.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;



@Entity
public class Exemplar {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
	@SequenceGenerator(name = "service_sequence", sequenceName = "service_sequence", allocationSize=1)
	private Long idexemplar;
	
	@ManyToOne
	@JoinColumn(name = "idlivro")
	private Livro livro;
	
	private boolean disponivel;
	
	public Exemplar()
	{
		
	}
	
	public Exemplar(Livro livro, boolean status)
	{
		this.setDisponivel(status);
		this.setLivro(livro);
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Long getIdexemplar() {
		return idexemplar;
	}
	public void setIdexemplar(Long idexemplar) {
		this.idexemplar = idexemplar;
	}	
	public boolean getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
