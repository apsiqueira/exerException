package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Conta;
import exception.DomainException;

public class Application {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		try {

			System.out.println("Entre com o numero da conta");
			Integer numero = scan.nextInt();

			System.out.println();

			System.out.println("Entre com o nome da conta");
			String nome = scan.next();
			
			System.out.println("Entre com o desposito");
			double deposito = scan.nextDouble();
		

			Conta c1 = new Conta(numero, nome,deposito);
			
			System.out.println(c1.toString());
			
			c1.ativarConta();
		
			System.out.println("Entre com o saque");
			double saque = scan.nextDouble();
			c1.Sacar(saque);
			System.out.println(c1.toString());

		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
	}

}
