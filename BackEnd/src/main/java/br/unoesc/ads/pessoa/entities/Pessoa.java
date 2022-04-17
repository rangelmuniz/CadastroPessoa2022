package br.unoesc.ads.pessoa.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String genero;
	private BigDecimal idade;
	
	
	public Pessoa() { }

	public Pessoa(Long id, String nome, String genero, BigDecimal idade) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
		
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getGenero() { return genero; }
	public void setQuantidade(String genero) { this.genero = genero; }
	
	public BigDecimal getIdade() { return idade; }
	public void setIdade(BigDecimal idade) {this.idade = idade;}


}

