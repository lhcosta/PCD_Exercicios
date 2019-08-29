package br.com.fumantes.utils;
import br.com.fumantes.enums.Ingrediente;

public class Mesa {
	
	private Ingrediente ingrediente = null;
	
	public synchronized void colocarIngrediente(Thread agente, Ingrediente ingrediente) {
		
		while(this.ingrediente != null) {
			try {
				wait();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(agente.getName() + " colocou um(a) " + ingrediente.getNome());
		this.ingrediente = ingrediente;
		
		notifyAll();
	}
	
	public synchronized void pegarIngrediente(Thread fumante, Ingrediente ingrediente) {
		
		while(this.ingrediente == null || this.ingrediente != ingrediente) {
			try {
				wait();
				System.out.println(fumante.getName() + " precisa de um(a) " + ingrediente.getNome() + " esta aguardando");
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(fumante.getName() + " pegou um(a) " + ingrediente.getNome());
		this.ingrediente = null;
		
		notifyAll();
	}
	
	

}
