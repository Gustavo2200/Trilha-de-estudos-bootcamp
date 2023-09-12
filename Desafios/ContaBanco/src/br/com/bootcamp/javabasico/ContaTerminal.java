package br.com.bootcamp.javabasico;

import java.util.Scanner;

public class ContaTerminal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Por favor, digite o numero da conta: ");
		int numero = input.nextInt();
		
		System.out.println("Agora digite o numero da agencia: ");
		input = new Scanner(System.in);
		String agencia = input.nextLine();
		
		System.out.println("Agora o nome do cliente: ");
		String nomeCliente = input.nextLine();
		
		System.out.println("Qual o saldo? ");
		double saldo = input.nextDouble();
		
		System.out.println("Ola "+ nomeCliente + " obrigado por criar uma conta no nosso banco, sua agencia e "+ agencia + ",");
		System.out.println("conta "+ numero + " e saldo " + saldo+ " ja disponivel pra saque.");
	}

}
