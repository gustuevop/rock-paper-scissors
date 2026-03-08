package jogo.entidades.menu.opcoes;

import jogo.entidades.Jogador;
import jogo.entidades.Resultado;
import jogo.entidades.Simbolo;
import regras.PedraPapelTesouraRegras;

import java.util.*;

public class OpcaoNovaPartida extends Opcao {
	private Scanner scanner = new Scanner(System.in);
	
	public OpcaoNovaPartida() {
		super("NOVA PARTIDA");
	}

	@Override
	public boolean executar(List<Jogador> jogadores) {
		System.out.println("\nLOG - Iniciando nova partida!\n");
		coletaSimbolos(jogadores);
		
		System.out.println("Símbolo do primeiro jogador: " + jogadores.get(0).simboloEscolhido.name());
		System.out.println("Símbolo do segundo jogador: " + jogadores.get(1).simboloEscolhido.name());
		
		Resultado resultJog1 = PedraPapelTesouraRegras.resultado(jogadores.get(0).simboloEscolhido, jogadores.get(1).simboloEscolhido);
		
		if (resultJog1 == Resultado.GANHOU) {
			System.out.println("Vencedor foi o jogador 0!");
		} else if (resultJog1 == Resultado.PERDEU) {
			System.out.println("Vencedor foi o jogador 1!");
		} else {
			System.out.println("EMPATE!");
		}
		
		return true;
	}

	private void coletaSimbolos(List<Jogador> jogadores) {
		System.out.println("\nLOG - Iniciando coleta de símbolos dos jogadores!\n");
		
		for (Jogador jogador : jogadores) {
			System.out.println("LOG - Coletando símbolo do jogador " + jogadores.indexOf(jogador));
			System.out.println("Escolha um símbolo: ");
			exibeSimbolos();
			jogador.simboloEscolhido = obterSimbolo();
		}
		System.out.println("\nLOG - Todos os jogadores coletaram os símbolos!\n");
	}

	private void exibeSimbolos() {
		Simbolo[] simbolos = Simbolo.values();
		for (int i = 0; i < simbolos.length; i++) {
			System.out.println(i + " - " + simbolos[i]);
		}	
	}

	private Simbolo obterSimbolo() {
		int simboloEscolhido = scanner.nextInt();
		return Simbolo.values()[simboloEscolhido];
	}
	
}
