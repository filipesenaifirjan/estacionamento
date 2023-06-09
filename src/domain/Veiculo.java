package domain;

import java.util.Date;

public abstract class Veiculo {

	private int hora;
	private Pessoa proprietario;
	private String placa;
	private String modelo;
	private Tipo tipo;
	
	@SuppressWarnings("deprecation")
	public Veiculo(Pessoa proprietario, String placa, String modelo, Tipo tipo) {
		this.proprietario = proprietario;
		this.placa = placa;
		this.modelo = modelo;
		this.tipo = tipo;
		
		Date date = new Date();
		this.hora = date.getHours();
	}
	
	  public Tipo getTipo() {
		return tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getHora() {
		return hora;
	}

	public Pessoa getProprietario() {
		return proprietario;
	}

	public String getModelo() {
		return modelo;
	}
	public abstract double getCustoInicial();
	public abstract double getCustoAdicional();
}
