package br.com.banheiro.utils;

public class Banheiro {
	
	private String lastSex = null;
	private int qtdPessoa = 0;
	private int maxPessoas = 2;
	
	
	public synchronized void entrar(Pessoa pessoa) {
						
		while((lastSex != null && lastSex != pessoa.getSexo()) || this.qtdPessoa == maxPessoas) {
			try {
				wait();
				pessoa.setPriority(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		} 
		

		System.out.println("Uma pessoa - " + pessoa.getSexo() + " entrou!");
		
		this.lastSex = pessoa.getSexo();
		
		qtdPessoa++;		
		
		notifyAll();
	}
	
	public synchronized void sair(Pessoa pessoa) {
		
		try {
			
			Thread.sleep(1000);
			wait(1000);
			System.out.println("Uma pessoa - " + pessoa.getSexo() + " saiu!");
			qtdPessoa--;
			System.out.println("\nPESSOAS BANHEIRO --> " + qtdPessoa + "\n");
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(qtdPessoa == 0) {
			this.lastSex = this.lastSex == "M" ? "F": "M"; 
		}
		
		notifyAll();
	}
	
	
}
