package br.com.banheiro.main;

import br.com.banheiro.utils.*;

public class Executer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banheiro banheiro = new Banheiro();		
		
		for(int i=0;i<20;i++) {
			new Pessoa("M", banheiro).start();
			new Pessoa("F", banheiro).start();
		}
	}

}
