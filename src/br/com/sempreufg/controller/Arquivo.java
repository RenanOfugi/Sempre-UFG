package br.com.sempreufg.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
}
