package br.com.qm.Escolinha.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	@Column(name = "cod_funcionario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codFuncionario;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false, name = "nivel_graduacao")
	private String nivelGraduacao;
	
	@Column(nullable = false)
	private float salario;
	
	@Column(nullable = false)
	private String disciplina;

	public Professor(String nome, String telefone, String nivelGraduacao, float salario,
			String disciplina) {
		this.nome = nome;
		this.telefone = telefone;
		this.nivelGraduacao = nivelGraduacao;
		this.salario = salario;
		this.disciplina = disciplina;
	}

	public Professor() {
		
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNivelGraduacao() {
		return nivelGraduacao;
	}

	public void setNivelGraduacao(String nivelGraduacao) {
		this.nivelGraduacao = nivelGraduacao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
}
