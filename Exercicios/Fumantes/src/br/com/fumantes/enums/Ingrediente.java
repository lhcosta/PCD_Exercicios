package br.com.fumantes.enums;

public enum Ingrediente {
	
	FOSFORO(1,"fosforo"), FUMO(2,"fumo"), PALHA(3,"palha");
	
	private int valor;
	private String nome;
	
	public static Ingrediente[][] pacoteIngrediente = {{Ingrediente.FOSFORO, Ingrediente.FUMO}, 
									{Ingrediente.FUMO, Ingrediente.PALHA},
									{Ingrediente.FOSFORO, Ingrediente.PALHA}};

	private Ingrediente(int valor, String nome) {
		// TODO Auto-generated constructor stub
		this.valor = valor;
		this.nome = nome;
	}
		
	public int getValor() {
		return valor;
	}
	
	public String getNome() {
		return nome;
	}

	public static Ingrediente getIngrediente(int valor) throws IllegalArgumentException {
		
		for(Ingrediente i : values()) {
			if(i.valor == valor) {
				return i;
			}
		}
		
		throw new IllegalArgumentException("Ingrediente nao existente");	
	}
	
	
}
 