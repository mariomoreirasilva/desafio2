package com.desvsuperior.desafio2.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	@OneToMany(mappedBy = "atividade")
	private Set<Bloco> blocos = new HashSet<>();
	@ManyToMany
	@JoinTable(name = "tb_participante_atividade",
			joinColumns = @JoinColumn(name = "id_atividade"),
			inverseJoinColumns = @JoinColumn(name = "id_participante"))
	private Set<Participante> participantes = new HashSet<>();
		
	public Atividade() {		
	}

	public Atividade(Integer id, String nome, String descriçao, Double preco) {		
		this.id = id;
		this.nome = nome;
		this.descricao = descriçao;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescriçao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	public Set<Bloco> getBlocos() {
		return blocos;
	}

	public Set<Participante> getParticipantes() {
		return participantes;
	}

	

}
