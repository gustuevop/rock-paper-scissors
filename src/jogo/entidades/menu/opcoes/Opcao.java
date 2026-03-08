package jogo.entidades.menu.opcoes;

import java.util.List;
import java.util.Scanner;

import jogo.entidades.Jogador;

public abstract class Opcao {
	
	private final String nome;

    protected Opcao(String nome) {
        this.nome = nome;
    }
	
	public String getNome() {
		return this.nome;
	}

	public abstract boolean executar(List<Jogador> jogadores);
}