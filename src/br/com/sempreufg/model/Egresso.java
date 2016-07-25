package br.com.sempreufg.model;

public class Egresso {

	private String nome;
	private String tipodoc;
	private String numdoc;
	private String datanasc;
	private static int qnt = 0;
	
	public void add(){
		qnt = getQnt() + 1;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public String getNumdoc() {
		return numdoc;
	}

	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public static int getQnt() {
		return qnt;
	}

}
