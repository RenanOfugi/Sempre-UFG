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

public class Arquivo {

	public void ler(String file) throws IOException{
		
		InputStream stream = new FileInputStream(file);
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);
		
		String line = reader.readLine();
		
		while (line != null){
			System.out.println(line);
			line = reader.readLine();
		}
		
		reader.close();
	}
	
	public void logArquivoInvalido(String log) throws IOException{
		
		OutputStream os = new FileOutputStream("Relato de Importacao.txt");
		OutputStreamWriter streamWriter = new OutputStreamWriter(os);
		BufferedWriter writer = new BufferedWriter(streamWriter);
		
		writer.write(log);
		
		writer.close();
	}
}
