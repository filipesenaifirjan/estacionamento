package domain;

public class Automovel extends Veiculo {
	
	private double custoInicial = 2.00;
	private double custoAdicional = 2.50;
	
	 public Automovel(Pessoa proprietario, String placa, String modelo, Tipo tipo) {
		super(proprietario, placa, modelo, tipo);

	}

	public double getCustoInicial() {
		return custoInicial;
	}

	public double getCustoAdicional() {
		return custoAdicional;
    	}
}