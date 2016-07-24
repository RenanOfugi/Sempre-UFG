package br.com.sempreufg.controller;

import java.io.IOException;

public class ManipulacaoArquivo {

	public void tratamentoArquivo(String file) throws IOException {
		
		Arquivo arquivo = new Arquivo();
		arquivo.ler(file);
	}
}
