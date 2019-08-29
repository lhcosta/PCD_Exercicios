package br.com.banheiro.utils;

public class Pessoa extends Thread {
	
	private String sexo;
	private Banheiro banheiro;
	
	public Pessoa(String sexo, Banheiro banheiro) {
		this.sexo = sexo;
		this.banheiro = banheiro;
	}
	
	@Override
	public void run() {
		banheiro.entrar(this);
		banheiro.sair(this);
	}

	public String getSexo() {
		return sexo;
	}
}
