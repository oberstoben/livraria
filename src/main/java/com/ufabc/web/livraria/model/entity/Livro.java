package com.ufabc.web.livraria.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;



@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
	@SequenceGenerator(name = "service_sequence", sequenceName = "service_sequence", allocationSize=1)
	private Long idlivro;
	private String titulo;
	private int edicao;
	private int ano;
	private String idioma;
	private String isbn;
	private String srcImagemCapa;
	@ManyToOne
	private Editora editora;
	
	
	@ManyToOne
	@JoinColumn(name = "idautor")
	private Autor autor;
	
	public Livro ()
	{
		
	}
	public Livro(String titulo, int edicao, int ano, String idioma, String isbn,
			String srcImagemCapa) {
		super();
		this.titulo = titulo;
		this.edicao = edicao;
		this.ano = ano;
		this.idioma = idioma;
		this.isbn = isbn;
		this.srcImagemCapa = srcImagemCapa;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Long getIdlivro() {
		return idlivro;
	}
	public void setIdlivro(Long id) {
		this.idlivro = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public String getSrcImagemCapa() {
		return srcImagemCapa;
	}
	public void setSrcImagemCapa(String srcImagemCapa) {
		this.srcImagemCapa = srcImagemCapa;
	}
}
