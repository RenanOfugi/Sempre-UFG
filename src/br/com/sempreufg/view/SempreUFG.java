package br.com.sempreufg.view;

import java.io.IOException;
import java.sql.SQLException;

import br.com.sempreufg.controller.ManipulacaoArquivo;

public class SempreUFG {

	public static void main(String[] args) throws IOException, SQLException{
		
		ManipulacaoArquivo arquivo = new ManipulacaoArquivo();
		arquivo.tratamentoArquivo(args[0]);
	}
}
