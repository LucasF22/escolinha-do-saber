package br.com.qm.Escolinha.Entity;

import java.util.ArrayList;
import java.util.List;

public class Turma { 
	
	private int codTurma;
	
	private String sala;
	
	private Professor professor;

	private List<Aluno> alunos;

	public Turma(int codTurma, String sala) {
		
		this.codTurma = codTurma;
		this.sala = sala;
		this.alunos = new ArrayList<Aluno>();
		
	}

	public Turma() {
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getCodTurma() {
		return codTurma;
	}

	public String getSala() {
		return sala;
	}
	
}
