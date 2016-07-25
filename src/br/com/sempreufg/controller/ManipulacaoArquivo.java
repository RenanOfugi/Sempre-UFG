package br.com.sempreufg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.sempreufg.controller.dao.CursoDAO;
import br.com.sempreufg.controller.dao.EgressoDAO;
import br.com.sempreufg.controller.dao.HistoricoUFGDAO;
import br.com.sempreufg.controller.dao.ProgramaAcademicoDAO;
import br.com.sempreufg.model.Curso;
import br.com.sempreufg.model.Egresso;
import br.com.sempreufg.model.HistoricoUFG;
import br.com.sempreufg.model.ProgramaAcademico;

public class ManipulacaoArquivo {

	public void tratamentoArquivo(String file) throws IOException, SQLException {

		Arquivo arquivo = new Arquivo();
		arquivo.ler(file);
	}

	public void redirecionaInsercao(ArrayList<String> entradas, String line) throws IOException, SQLException {

		if (entradas.get(0).equals("Reg.1")) {
			redirecionaReg1(entradas);
		} else if (entradas.get(0).equals("Reg.2")) {
			redirecionaReg2(entradas);
		} else {
			Arquivo.log(line,false);
		}
	}

	public void redirecionaReg1(ArrayList<String> entradas) throws SQLException, IOException {
		
		Egresso egresso = new Egresso();
		Valores valores = new Valores();
		valores.valoresNoObjetoReg1(egresso, entradas);
		EgressoDAO egressoDAO = new EgressoDAO();
		egressoDAO.insert(egresso);
		
		egresso.add();
		Arquivo.log("Insersao valida", true);
		
		/*Curso curso = new Curso();
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.valoresNoObjetoReg1(curso, entradas);
		cursoDAO.insert(curso);
		
		HistoricoUFG historicoUFG = new HistoricoUFG();
		HistoricoUFGDAO ufgdao = new HistoricoUFGDAO();
		ufgdao.valoresNoObjeto(historicoUFG, entradas);
		ufgdao.insert(historicoUFG);*/

	}

	public void redirecionaReg2(ArrayList<String> entradas) throws SQLException {
		
		Egresso egresso = new Egresso();
		Valores valores = new Valores();
		valores.valoresNoObjetoReg2(egresso, entradas);
		EgressoDAO egressoDAO = new EgressoDAO();
		egressoDAO.insert(egresso);
		
		Curso curso = new Curso();
		CursoDAO cursoDAO = new CursoDAO();
		cursoDAO.valoresNoObjetoReg2(curso, entradas);
		cursoDAO.insert(curso);
		
		ProgramaAcademico academico = new ProgramaAcademico();
		ProgramaAcademicoDAO academicoDAO = new ProgramaAcademicoDAO();
		academicoDAO.valoresNoObjeto(academico, entradas);
		academicoDAO.insert(academico);
	}
	
}
