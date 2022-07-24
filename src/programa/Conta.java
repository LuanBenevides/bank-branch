package programa;

import utilitarios.Utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private double saldo = 0.0;

	public Conta(Pessoa pessoa) {
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		
		return "\nNumero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.pessoa.getNome() +
				"\nCPF: " + this.pessoa.getCpf() +
				"\nE-mail: " + this.pessoa.getEmail() +
				"\nSaldo: " + Utils.doubleToString(this.getSaldo())+
				"\n";
	}
	
	public void depositar(double valorDeposito) {
		if(valorDeposito > 0) {
			setSaldo(getSaldo() + valorDeposito);
			System.out.println("O seu deposito foi realizado com sucesso!");
		}else {
			System.out.println("Nao foi possivel realizar o deposito!");
		}
	}
	public void sacar(double valorSaque) {
		if(valorSaque > 0 && this.getSaldo() >= valorSaque) {
			setSaldo(getSaldo() - valorSaque);
			System.out.println("O seu saque foi realizado com sucesso!");
		}else {
			System.out.println("Nao foi possivel realizar o saque!");
		}
	}
	
	public void transferir(Conta contaParaDeposito, double valorTransferido) {
		if(valorTransferido > 0 && this.getSaldo() >= valorTransferido) {
			setSaldo(getSaldo() - valorTransferido);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valorTransferido;
			System.out.println("Transferencia realizada com sucesso");
		}else {
			System.out.println("Nao foi possivel realizar a transferencias!");
		}
	}
}
