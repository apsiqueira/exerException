package entities;

import exception.DomainException;

public class Conta {

	private Integer numero;
	private String nomeConta;
	private Double saldo ;
	private Double limite;
	private boolean status;
	
	public Conta(Integer numero, String nomeConta,Double saldo) throws DomainException {
		this.saldo=saldo;
		this.numero = numero;
		this.nomeConta = nomeConta;
		if (saldo!=0) {
		ativarConta();
		}
		

	}


	public Conta(Integer numero, String nomeConta) {
		this.numero = numero;
		this.nomeConta = nomeConta;
		this.status = false;

	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta(String nomeConta) {
		this.nomeConta = nomeConta;
	}

	public boolean getStatus() {
		return status;
	}

	public void depositar(double deposito) throws DomainException {
		if (this.getStatus() == false) {
			throw new DomainException("Conta inativa");
		} else {
			this.saldo = saldo + deposito;

		}

	}

	private void concederLimite() throws DomainException {
		
		if (this.saldo > 0 && this.saldo<=100) {
			this.limite = 50d;

		} 
		else if(this.saldo==null || this.saldo==0) {
		
			throw new DomainException("Conta so recebera limite apos o primeiro deposito");
		}
		
		else {

			this.limite = 200d;
		}
		this.saldo += this.limite;

	}

	public void ativarConta() throws DomainException {
		if (status != false && status != true) {
			throw new DomainException("conta inexistente");

		} else if (status == true) {
			throw new DomainException("conta ja ativa");

		} else {
			System.out.println("Ativando conta");
			status = true;
			concederLimite();

		}

	}

	public void Sacar(double saque) {
		if (this.getStatus() != false && this.saldo >= saque) {
			this.saldo -= saque;

		} else {
			System.out.println("sem saldo");

		}

	}

	@Override
	public String toString() {
		return "Conta numero=" + numero + ", nomeConta=" + nomeConta + ", saldo=" + saldo + ", limite=" + limite
				+ ", status=" + status + "]";
	}

}
