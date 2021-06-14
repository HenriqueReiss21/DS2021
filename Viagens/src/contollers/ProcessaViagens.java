package contollers;

import java.util.ArrayList;
import models.Viagem;

public class ProcessaViagens {
	public static ArrayList<Viagem> viagens = new ArrayList<>();

	public static double getTempoTotal() {
		double total = 0;
		for (Viagem v : viagens) {
			total += v.getTempo();
		}
		return total;
	}
}
