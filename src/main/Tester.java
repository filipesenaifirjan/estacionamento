package main;

import java.util.ArrayList;

import domain.Estacionamento;
import domain.Pessoa;
import domain.Tipo;
import domain.Veiculo;

public class Tester {	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
            
            Pessoa p1 = new Pessoa("Filipe", "111.222.333-44", "(21) 2222-3333");
		System.out.println(estacionamento.entraVeiculo("ltz 9098", "Polo", Tipo.CARRO, p1));
		
		System.out.println(estacionamento.entraVeiculo("klk 3487", "Gol", Tipo.CARRO, p1));
		
		System.out.println(estacionamento.entraVeiculo("gth 2290", "Monza", Tipo.MOTO, p1));
		System.out.println(estacionamento.entraVeiculo("XpX 6245", "Opala", Tipo.MOTO, p1));

		System.out.println("------");
		System.out.println(estacionamento.saiVeiculo("mnk 9510"));
		
		ArrayList<Veiculo> lista = estacionamento.listaEstacionados();
		for (int i=0; i < lista.size(); i++)
			 System.out.println(lista.get(i).getPlaca());
		
	  } 

}
