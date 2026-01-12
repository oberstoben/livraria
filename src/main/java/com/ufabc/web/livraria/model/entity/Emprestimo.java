package com.ufabc.web.livraria.model.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue
	private Long idemprestimo;
	private Date dataDoEmprestimo;
	private Date dataDeRetorno;
	
	@ManyToOne
	private Exemplar livro;
	
	@ManyToOne
	private Cliente cliente;
	
	public Emprestimo(){
		
	}
	public Emprestimo(Cliente cliente, Exemplar exemplar, Date dataDoEmprestimo, Date dataDeRetorno){
		exemplar.setDisponivel(false);
		this.setCliente(cliente);
		this.setDataDoEmprestimo(dataDoEmprestimo);
		this.setDataDeRetorno(dataDeRetorno);
		this.setExemplar(exemplar);
	}
	public Long getIdemprestimo() {
		return idemprestimo;
	}
	public void setIdemprestimo(Long id) {
		this.idemprestimo = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}
	public void setDataDoEmprestimo(Date dataDoEmprestimo) {
		this.dataDoEmprestimo = dataDoEmprestimo;
	}
	public Date getDataDeRetorno() {
		return dataDeRetorno;
	}
	public void setDataDeRetorno(Date dataDeRetorno) {
		this.dataDeRetorno = dataDeRetorno;
	}
	public void setExemplar(Exemplar livro)
	{
		this.livro = livro;
	}
	public Exemplar getExemplar()
	{
		return livro;
	}
	
}
