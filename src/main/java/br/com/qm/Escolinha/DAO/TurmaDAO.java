package br.com.qm.Escolinha.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.qm.Escolinha.Entity.Aluno;
import br.com.qm.Escolinha.Entity.Professor;
import br.com.qm.Escolinha.Entity.Turma;
import br.com.qm.Escolinha.exception.EscolinhaException;


public class TurmaDAO { 

	private Map<Integer, Turma> turmas;
	private ProfessorDAO professorDao;
	private AlunoDAO alunoDao;

	public TurmaDAO(AlunoDAO alunoDao, ProfessorDAO professorDao) {
		this.turmas = new HashMap<Integer, Turma>();
		this.professorDao = professorDao;
		this.alunoDao = alunoDao;
	}

	public boolean cadastrarTurma(Turma turma) throws EscolinhaException {
		
		if (this.turmas.get(turma.getCodTurma()) != null) {
			throw new EscolinhaException("Turma já existe. Verifique codigo se está correto!");
		}
		
		if (turma.getProfessor() != null)  {
			throw new EscolinhaException("Professor já cadastrado em turma. Verifique codigo se está correto!");
		}
		
		if (turma.getAlunos().size() > 0)  {
			throw new EscolinhaException("Nova turma não pôde ser cadastrada. Existem alunos vinculados a turma.");
		}
		
		this.turmas.put(turma.getCodTurma(), turma);
		
		return true;
	}
	
	public boolean adicionaProfessor(int codProfessor, int codTurma) throws EscolinhaException{
		
		Turma turma = this.turmas.get(codTurma);
		
		turmaNaoExiste(turma);
		
		if (turma.getProfessor() != null) {
			throw new EscolinhaException("Turma já possui professor. Verifique código se está correto.");
		}
		
		Professor professorAdicionado = this.professorDao.consultaProfessor(codProfessor);
		
		if (professorAdicionado == null) {
			throw new EscolinhaException("Professor não existe. Verifique codigo se está correto!");
		}
		turma.setProfessor(professorAdicionado);
		
		return true;
	}
	
	public boolean adicionaAluno(int matricula, int codTurma) throws EscolinhaException {
		
		Turma turma = this.turmas.get(codTurma);
		
		turmaNaoExiste(turma);
		
		if (turma.getProfessor() == null) {
			throw new EscolinhaException("Turma não possui professor.");
		}
		
		Aluno alunoAdicionado = this.alunoDao.consultaAluno(matricula);
		
		if (alunoAdicionado == null) {
			throw new EscolinhaException("Aluno não matriculado! Verifique matricula está correta");
		
		}
		
		boolean alunoPresente = false;
		for (Aluno aluno : turma.getAlunos()) {
			
			if (aluno.getMatricula() == matricula) {
				alunoPresente = true;
			}
			
		}
		
		if (alunoPresente) {
			throw new EscolinhaException("Aluno não pôde ser cadastrado nesta turma. Porque já está cadastrado na turma. ");

		}
		
		turma.getAlunos().add(alunoAdicionado);
		return true;
	}
	
	public List<Turma> listaTurmas() {
		
		return (List<Turma>) this.turmas.values();
		
	}
	
	public boolean removeTurma(int codTurma) throws EscolinhaException {
		
		if (this.turmas.get(codTurma) == null) {
			throw new EscolinhaException("Turma não existe. Verifique codigo se está correto.");
		}
		
		this.turmas.remove(codTurma);
		return true;
	}
	
	public boolean listaDeChamada(int codTurma) throws EscolinhaException {
		
		Turma turma = this.turmas.get(codTurma);
		
		turmaNaoExiste(turma);
		
		List<Aluno> alunos = turma.getAlunos();
		
		if (alunos.size() == 0) {
			throw new EscolinhaException("Não existe alunos nesta turma.");
		}

		try {
			FileWriter fw = new FileWriter("chamada_" + turma.getCodTurma() + turma.getSala());
			
			fw.write(String.format("Turma %d - Sala %s\n", turma.getCodTurma(), turma.getSala()));
			fw.write(String.format("Professor: %s\n", turma.getProfessor().getNome()));
			
			fw.write("Nome\tMatrÃ­cula\n");
			for (Aluno aluno : alunos) {
				
				fw.write(String.format("%s %5d\n", aluno.getNome(), aluno.getMatricula()));
				
			}
			
			fw.close();
			
		} catch (IOException e) {
			System.err.println("Erro ao escrever arquivo: " + e.getMessage());
		}
		
		return true;
	}
	public void turmaNaoExiste(Turma turma) throws EscolinhaException {		
		if (turma == null) {
			throw new EscolinhaException("Turma não existe. Verifique codigo se está correto.");
		}
	}
}
