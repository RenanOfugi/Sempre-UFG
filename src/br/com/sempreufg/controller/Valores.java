package br.com.sempreufg.controller;

import java.util.ArrayList;

import br.com.sempreufg.model.Egresso;

public class Valores {

	public void valoresNoObjetoReg1(Egresso egresso, ArrayList<String> entradas) {

		egresso.setNome(entradas.get(1));
		egresso.setTipodoc(entradas.get(2));
		egresso.setNumdoc(entradas.get(3));
		egresso.setDatanasc(entradas.get(4));
	}

	public void valoresNoObjetoReg2(Egresso egresso, ArrayList<String> entradas) {

		egresso.setNome("");
		egresso.setTipodoc(entradas.get(1));
		egresso.setNumdoc(entradas.get(2));
		egresso.setDatanasc("");
	}
}
