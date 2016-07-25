package br.com.sempreufg.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import br.com.sempreufg.model.Egresso;

public class Arquivo {

	public void ler(String file) throws IOException, SQLException {

		ManipulacaoArquivo arquivo = new ManipulacaoArquivo();
		InputStream stream = new FileInputStream(file);
		InputStreamReader streamReader = new InputStreamReader(stream, "UTF-8");
		BufferedReader reader = new BufferedReader(streamReader);

		String line;

		while ((line = reader.readLine()) != null) {
			System.out.println(line);

			ArrayList<String> entradas = tratamento(line);

			if (entradas != null) {
				arquivo.redirecionaInsercao(entradas, line);
			}
		}

		reader.close();
	}

	public static void log(String log, boolean aprovado) throws IOException {

		String invalido = "Insercao invalida";
		
		OutputStream os = new FileOutputStream("Relato de Importacao.txt");
		OutputStreamWriter streamWriter = new OutputStreamWriter(os);
		BufferedWriter writer = new BufferedWriter(streamWriter);
		
		if(aprovado){
			
			writer.write(log + ": Inserido " + Integer.toString(Egresso.getQnt()) + " egressos");
		} else {
			writer.write(invalido + log);
		}
		
		writer.close();
	}

	public ArrayList<String> tratamento(String line) {

		String[] entradaTratar = corte(line);
		ArrayList<String> entradas = convertArrayList(entradaTratar);

		return entradas;
	}

	private String[] corte(String line) {

		if (line != null) {
			String[] entradas = line.split("\\\\");
			return entradas;
		} else {
			return null;
		}
	}

	private ArrayList<String> convertArrayList(String[] entradaTratar) {

		if (entradaTratar != null) {
			ArrayList<String> entradas = new ArrayList<String>(Arrays.asList(entradaTratar));
			return entradas;
		} else {
			return null;
		}
	}
}
