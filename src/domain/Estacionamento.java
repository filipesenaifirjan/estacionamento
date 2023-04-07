package domain;

import java.util.ArrayList;
import java.util.Date;

public class Estacionamento {

	private Veiculo[][] vaga = new Veiculo[60][2];
	int nrVeiculos = 0;
	
	public int getNrVeiculos() {
        return nrVeiculos;
    }
	
	public boolean entraVeiculo(String placa, String modelo, Tipo tipo, Pessoa proprietario){
        for (int a=0; a < this.vaga.length; a++){
            if (tipo.equals(Tipo.CARRO)){
            	Automovel carro = new Automovel(proprietario, placa, modelo, Tipo.CARRO);
                if (this.vaga[a][0] == null && this.vaga[a][1] == null){
                    this.vaga[a][0] = carro;
                    nrVeiculos++;
                    return true;
                }
            } else {
            	Motocicleta moto = new Motocicleta(proprietario, placa, modelo, Tipo.MOTO);
                if (this.vaga[a][0] == null){
                    this.vaga[a][0] = moto;
                    nrVeiculos++;
                    return true;
                } else if (this.vaga[a][0].getTipo().equals(Tipo.MOTO)){
                    if (this.vaga[a][1] == null){
                        this.vaga[a][1] = moto;
                        nrVeiculos++;
                        return true;
                    }
                }
            }
        }
        return false;
    }
	
	private void removeVeiculo(int g, int l){
        this.vaga[g][l] = null;
        nrVeiculos--;
    }
    
    private float calculaConta(int g, int l){
        float total = 0;
        if (this.vaga[g][l] != null){
            Date data = new Date();
            @SuppressWarnings("deprecation")
			int horaAtual = data.getHours();
			int tempo = horaAtual - this.vaga[g][l].getHora();
			if (tempo <= 1) {
				total = (float) this.vaga[g][l].getCustoInicial();
			} else {
				total = (float) (((tempo - 1) * this.vaga[g][l].getCustoAdicional()) + this.vaga[g][l].getCustoInicial());
			}
        }
        return total;
    }
    
    public float saiVeiculo(String placa){
        float conta = 0;
        for (int a=0; a < this.vaga.length; a++){
            if (this.vaga[a][0] != null){
                if (placa.equals(this.vaga[a][0].getPlaca())){
                    conta = calculaConta(a, 0);
                    removeVeiculo(a, 0);
                    return conta;
                }
                } else if (this.vaga[a][1] != null){
                    if (placa.equals(this.vaga[a][1].getPlaca())){
                        conta = calculaConta(a, 1);
                        removeVeiculo(a, 1);
                        return conta;
                    }   
                }
        }
        return conta;
    }
	
    public ArrayList<Veiculo> listaEstacionados(){
    	ArrayList<Veiculo> lista = new ArrayList<>();
        for (int a=0; a < this.vaga.length; a++){
            if (this.vaga[a][0] != null){
            	lista.add(this.vaga[a][0]);
            }
            if (this.vaga[a][1] != null){
            	lista.add(this.vaga[a][1]);
            }
        }
          return lista;
    }  
}