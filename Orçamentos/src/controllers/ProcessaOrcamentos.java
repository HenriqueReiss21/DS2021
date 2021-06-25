package controllers;

import java.util.ArrayList;
import models.Orcamento;

public class ProcessaOrcamentos {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<>(); 
	
	public static Orcamento getMaisBarato() {
		double menor = orcamentos.get(0).getPreco();
		int cont = 0;
		int i = 0;
		
		for (Orcamento o : orcamentos) {
			
			if (o.getPreco() < menor) {
				menor = o.getPreco();
				i = cont;
			}
			cont += 1;
		}
		return orcamentos.get(i);
	}	
}
