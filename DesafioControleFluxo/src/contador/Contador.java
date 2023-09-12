package contador;

import java.util.Scanner;

public class Contador {

	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in); 
		int parametroUm = terminal.nextInt();
		int parametroDois = terminal.nextInt();
		try {
			contar(parametroUm, parametroDois);
		}
		catch (ParametrosInvalidosException e) {
			System.out.println("Segundo parametro deve ser menor que o primeiro");
		}
	}
	static void contar(int parametroUm, int parametroDois)throws ParametrosInvalidosException {
		if(parametroDois > parametroUm) {
			throw new ParametrosInvalidosException();
		}
		else {
			int contagem = parametroUm - parametroDois;
			for(int i=1;i<=contagem;i++) {
				System.out.println(i);
			}
		}
	}
}
