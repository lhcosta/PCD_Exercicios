package br.com.fumantes.main;

import br.com.fumantes.enums.Ingrediente;
import br.com.fumantes.utils.*;

public class Executer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				 		
		Mesa mesa = new Mesa();
		Agente agente = new Agente("Agente#1", mesa);
			
		for(int i=0;i<3;i++) {
			Fumante f = new Fumante("Fumante#" + (i+1), mesa, Ingrediente.pacoteIngrediente[i]);
			System.out.println(f.toString());
			f.start();
		}	
		
		System.out.println("\n");
		agente.start();
	}

}
