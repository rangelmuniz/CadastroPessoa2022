package br.unoesc.ads.pessoa.dto;

import java.math.BigDecimal;

import br.unoesc.ads.pessoa.entities.Pessoa;

public class PessoaDTO {
	private Long id;
	private String nome;
	private String genero;
	private BigDecimal idade;

	
	public PessoaDTO() { }

	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.genero = pessoa.getGenero();
		this.idade = pessoa.getIdade();
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }
	
	public BigDecimal getIdade() { return idade; }
	public void setIdade(BigDecimal idade) { this.idade = idade; }


}