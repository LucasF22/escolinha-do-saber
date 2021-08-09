package br.com.qm.Escolinha.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricula;
	
	@Column(nullable = false, length = 60)
	private String nome;
	
	@Column(nullable = false)
	private int serie;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "data_promocao")
	private LocalDate dataPromocao;

	public Aluno(String nome, int serie, LocalDate dataNascimento, LocalDate dataPromocao) {
		this.nome = nome;
		this.serie = serie;
		this.dataNascimento = dataNascimento;
		this.dataPromocao = dataPromocao;
	}

	public Aluno() {
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataPromocao() {
		return dataPromocao;
	}

	public void setDataPromocao(LocalDate dataPromocao) {
		this.dataPromocao = dataPromocao;
	}
	
}

