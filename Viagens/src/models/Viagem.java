package models;

public class Viagem {
	private int id;
	private String origem;
	private String destino;
	private int distancia;
	private int velocidade;
	
	public Viagem() {

	}

	public Viagem(int id, String origem, String destino, int distancia, int velocidade) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.velocidade = velocidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id + "\t" + origem + "\t" + destino + "\t" + distancia
				+ "\t" + velocidade + "\t" + String.format("%.2f",getTempo()) + "\n";
	}
	
	public double getTempo() {
		return (double)distancia/velocidade;
	}
	
	
}
