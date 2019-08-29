package br.com.fumantes.utils;
import java.util.Random;

import br.com.fumantes.enums.Ingrediente;

public class Agente extends Thread {
	
	private Mesa mesa;
	
	public Agente(String nome, Mesa mesa) {
		super(nome);
		this.mesa = mesa;
	}
	
	@Override
	public void run() {
		while(true) {
			this.mesa.colocarIngrediente(this, this.sortearIngrediente());
		}
	}
	
	private Ingrediente sortearIngrediente() {
		
		Random random = new Random();
		int ingrediente = random.nextInt(3-1) + 1;
		
		return Ingrediente.getIngrediente(ingrediente);
	}
	
}
