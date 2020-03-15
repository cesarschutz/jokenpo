package com.cesar.jokenpo.application;

import com.cesar.jokenpo.domain.game.Jokenpo;
import com.cesar.jokenpo.domain.values.JokenpoValues;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Cesar Schutz
 */
@Component
public class ApplicationRunner implements CommandLineRunner {

    private final Scanner inputScanner;

    public ApplicationRunner(final Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    @Override
    public void run(String... args) {
        init();
    }

    private void init() {
        System.out.println("###############################################");
        System.out.println("###############################################");
        System.out.println("######                                   ######");
        System.out.println("######     Bem-vindo ao jogo Jokenpo     ######");
        System.out.println("######                                   ######");
        System.out.println("###############################################");
        System.out.println("###############################################");
        System.out.println();
        start();
    }

    private void start() {
        System.out.println("Selecione uma das opções:");
        System.out.println("1 - Um jogador");
        System.out.println("2 - Dois jogadores");
        System.out.println("3 - Sair");
        System.out.print("Digite sua opção: ");

        final int selectedOption = inputScanner.nextInt();
        System.out.println();

        play(selectedOption);
    }

    private void play(int selectedOption) {
        switch (selectedOption) {
            case 0:
                break;
            case 1:
                playOnePlayer();
                break;
            case 2:
                playTwoPlayer();
                break;
            default:
                System.out.println("Opção inválida!.\n");
                start();
        }
    }

    private void playOnePlayer() {
        final JokenpoValues valuePlayer = getValuePlayer("Selecione um dos valores:");
        final JokenpoValues valueComputer = JokenpoValues.randomJokenpoValues();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(String.format("Valor selecionado pelo jogador: %s", valuePlayer));
        System.out.println(String.format("Valor selecionado pelo computador: %s", valueComputer));
        switch (Jokenpo.run(valuePlayer, valueComputer)) {
            case 0:
                System.out.println("EMPATOU!");
                break;
            case 1:
                System.out.println("VOCÊ VENCEU!");
                break;
            case -1:
                System.out.println("VOCÊ PERDEU!");
                break;
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        playAgain();
    }

    private void playTwoPlayer() {
        final JokenpoValues valuePlayer1 = getValuePlayer("Selecione o valor do Jogador 1:");
        final JokenpoValues valuePlayer2 = getValuePlayer("Selecione o valor do Jogador 2:");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(String.format("Valor selecionado pelo jogador 1: %s", valuePlayer1));
        System.out.println(String.format("Valor selecionado pelo jogador 2: %s", valuePlayer2));
        switch (Jokenpo.run(valuePlayer1, valuePlayer2)) {
            case 0:
                System.out.println("EMPATOU!");
                break;
            case 1:
                System.out.println("JOGADOR 1 VENCEU!");
                break;
            case -1:
                System.out.println("JOGADOR 2 VENCEU!");
                break;
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        playAgain();
    }

    private JokenpoValues getValuePlayer(final String message) {
        System.out.println(message);
        System.out.println("0 - Pedra");
        System.out.println("1 - Papel");
        System.out.println("2 - Tesoura");
        System.out.print("Digite sua opção: ");

        final int selected = inputScanner.nextInt();
        System.out.println();

        try {
            return JokenpoValues.from(selected);
        } catch (final IllegalStateException ise) {
            System.out.println("Opção inválida!.\n");
            return getValuePlayer(message);
        }
    }

    private void playAgain() {
        System.out.println("Deseja jogar novamente?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Digite sua opção: ");
        final int selected = inputScanner.nextInt();
        System.out.println();

        switch (selected) {
            case 1:
                start();
            case 2:
                break;
            default:
                System.out.println("Opção inválida!.\n");
                playAgain();
        }
    }
}