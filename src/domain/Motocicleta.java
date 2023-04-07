
package domain;

public class Motocicleta extends Veiculo {

	private double custoInicial = 2.00;
	private double custoAdicional = 1.50;
	
	public Motocicleta(Pessoa proprietario, String placa, String modelo, Tipo tipo) {
		     super(proprietario, placa, modelo, tipo);

	}

	 public double getCustoInicial() {
		return custoInicial;
	}

	public double getCustoAdicional() {
		return custoAdicional;
	}
	
}