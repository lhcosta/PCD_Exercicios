package br.com.fumantes.utils;
import java.util.ArrayList;

import br.com.fumantes.enums.Ingrediente;

public class Fumante extends Thread {
	
	private Mesa mesa;
	private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	public Fumante(String nome, Mesa mesa, Ingrediente[] ingredientes) {
		super(nome);
		this.mesa = mesa;
		
		for(Ingrediente i : ingredientes) {
			this.ingredientes.add(i);
		}
	}
	
	@Override
	public void run() {
		while(true) {
			this.mesa.pegarIngrediente(this, this.fazerCigarro());
		}
	}
	
	//Ingrediente que falta para fazer o cigarro
	private Ingrediente fazerCigarro() {
		
		if(!ingredientes.contains(Ingrediente.FOSFORO)) {
			return Ingrediente.FOSFORO;
		}
		
		if(!ingredientes.contains(Ingrediente.FUMO)) {
			return Ingrediente.FUMO;
		}
		
		return Ingrediente.PALHA;
	}
	
	@Override
	public String toString() {
		return this.getName() + " [ingredientes=" + ingredientes + "]";
	}

}
