package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		int operacaoEscolhida;
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("--------------------Bem vindo a agencia bancaria----------------------");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("*********  Selecione uma operacao que deseja realizar ****************");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|    Opcao 1 - Criar uma conta |                                     |");
		System.out.println("|    Opcao 2 - Depositar       |                                     |");
		System.out.println("|    Opcao 3 - Sacar           |                                     |");
		System.out.println("|    Opcao 4 - Transferir      |                                     |");
		System.out.println("|    Opcao 5 - Listar contas   |                                     |");
		System.out.println("|    Opcao 6 - Sair            |                                     |");
		System.out.println("----------------------------------------------------------------------");
		
		operacaoEscolhida = entrada.nextInt();
	
		switch(operacaoEscolhida) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por usar a nossa agencia! Esperamos te ver novamente em breve...");
			System.exit(0);
			
		default:
			System.out.println("Opcao invalida!");
			operacoes();
			break;
		}
	}
	
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = entrada.next();
		
		System.out.println("\nCPF: ");
		String cpf = entrada.next();
		
		System.out.println("\nE-mail: ");
		String email = entrada.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
	
		contasBancarias.add(conta);
		
		System.out.println("A sua conta foi criada com sucesso!");
		
		operacoes();
	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		System.out.println("Informe o numero da conta: ");
		int numeroConta = entrada.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
	
		if(conta != null) {
			System.out.println("Informe o valor a ser depositado? ");
			double valorDeposito = entrada.nextDouble();
			
			conta.depositar(valorDeposito);
			System.out.println("Valor depositado com sucesso!");
		}else {
			System.out.println("A conta de deposito nao foi encontrada!");
		}
		operacoes();
	}

	public static void sacar() {
		System.out.println("Informe o numero da conta: ");
		int numeroConta = entrada.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.println("Informe o valor que deseja sacar? ");
			double valorDoSaque = entrada.nextDouble();
			
			conta.sacar(valorDoSaque);
		}else {
			System.out.println("A conta de saque nao foi encontrada!");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Informe a conta do remetente: ");
		int numeroContaRemetente = entrada.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Informe a conta do destinatario: ");
			int numeroContaDestinatario = entrada.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
		
			if(contaDestinatario != null) {
				System.out.println("Qual e o valor da transferencia: ");
				double valorTransferencia = entrada.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valorTransferencia);
			}else {
				System.out.println("Conta para transferencia nao encontrada!");
			}
		}else {
			System.out.println("Conta para transferencia nao encontrada!");
		}
		operacoes();
	}

	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta contaPercorre: contasBancarias) {
				System.out.println(contaPercorre);
			}
		}else {
			System.out.println("Nao ha contas cadastradas nessa agencia!");
		}
		operacoes();
	}	
}