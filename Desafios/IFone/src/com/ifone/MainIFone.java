package com.ifone;

import java.util.Scanner;

public class MainIFone {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IFone ifone = new IFone();
        ifone.ligar();
        char character = '1';
        while (character != 'd') {
            System.out.println("Teste por si mesmo as funcionalidades do nosso ifone!!\n" +
                    "Precione 'a' para aparelho telefonico, 'n' para navegar na internet, \n" +
                    "'r' para o reprodutor musical, ou 'd' para desligar: ");
            character = input.next().charAt(0);
            input.nextLine(); // Consumir a nova linha pendente

            switch (character) {
                case 'a':
                    boolean repetidor = true;
                    while (repetidor) {
                        System.out.println("a.chamar\nb.atender\nc.correio de voz\nd.voltar");
                        char caseA = input.next().charAt(0);
                        input.nextLine(); // Consumir a nova linha pendente
                        if (caseA == 'a') {
                            System.out.println("Digite o telefone:");
                            long numero = input.nextLong();
                            input.nextLine(); // Consumir a nova linha pendente
                            ifone.telefoneChamar(numero);
                        } else if (caseA == 'b') {
                            System.out.println("O seu Ifone esta chamando atender? 's' ou 'n'");
                            char confirmacaoAtender = input.next().charAt(0);
                            input.nextLine(); // Consumir a nova linha pendente
                            if (confirmacaoAtender == 's') {
                                ifone.telefoneAtender();
                            } else {
                                System.out.println("Chamada recusada");
                            }
                        } else if (caseA == 'c') {
                            ifone.telefoneIniciarCorreioDeVoz();
                        } else {
                            repetidor = false;
                        }
                    }
                    break;

                case 'n':
                    boolean repetidorCaseN = true;
                    while (repetidorCaseN) {
                        System.out.println("a.pesquisar\nb.nova guia\nc.atualizar pagina\nd.voltar");
                        char caseN = input.next().charAt(0);
                        input.nextLine(); // Consumir a nova linha pendente
                        if (caseN == 'a') {
                            System.out.println("Didgite a url");
                            String url = input.nextLine();
                            ifone.exibirPaginaNavegador(url);
                        } else if (caseN == 'b') {
                            System.out.println("Digite a url");
                            String url = input.nextLine();
                            ifone.adicionarNovaPaginaNavegador(url);
                        } else if (caseN == 'c') {
                            ifone.atualizarPaginaNavegador();
                        } else {
                            repetidorCaseN = false;
                        }
                    }
                    break;

                case 'r':
                    boolean repetidorCaseR = true;
                    while (repetidorCaseR) {
                        System.out.println("a.tocar\nb.pausar\nc.escolher musica\nd.voltar");
                        char caseR = input.next().charAt(0);
                        input.nextLine(); // Consumir a nova linha pendente
                        if (caseR == 'a') {
                            ifone.ipodTocar();
                        } else if (caseR == 'b') {
                            ifone.ipodPausar();
                        } else if (caseR == 'c') {
                            System.out.println("Digite o nome da musica:");
                            String musica = input.nextLine();
                            ifone.ipodSelecionarMusica(musica);
                        } else {
                            repetidorCaseR = false;
                        }
                    }
                    break;
            }
        }
        input.close(); // Fechar o Scanner quando não for mais necessário
        ifone.desligar();
    }
}
