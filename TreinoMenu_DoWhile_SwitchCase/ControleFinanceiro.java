import java.util.Scanner;

public class ControleFinanceiro {

    public static void main(String[] args) {

     Scanner scanner = new Scanner(System.in);

     int opcao;
     double renda = 0.0;
     String despesa;
     double valor;
     double saldo = 0.0;

     do {

      System.out.println("====================");  
      System.out.println("CONTROLE FINANCEIRO");
      System.out.println("====================");  
      System.out.println();  
      System.out.println("1 - Cadastrar renda");    
      System.out.println("2 - Adicionar despesa"); 
      System.out.println("3 - Ver saldo");
      System.out.println("4 - fazer depósito");
      System.out.println("5 - Sair");
      System.out.println();  
      System.out.println("Escolha uma opção:");
      opcao = scanner.nextInt();

      scanner.nextLine(); // Limpa o ENTER que ficou no buffer após o nextInt()

      switch (opcao) {

        case 1: 
            System.out.println("Digite sua renda mensal:");

            renda = scanner.nextDouble();

            System.out.println("Renda cadastrada com sucesso!");

            break;

        case 2: 
            System.out.println("Adicione o nome da despesa:");

            despesa = scanner.nextLine(); 

            System.out.println("Adicione o valor da despesa:");

            valor = scanner.nextDouble();

            saldo = saldo - valor;

            System.out.println("Despesa adicionada com sucesso!");

            System.out.println("Saldo: R$ " + saldo);

            break;

        case 3:
            System.out.println("Seu saldo é R$ " + saldo);

            break;

        case 4:

           int opcaoDeposito;
           double deposito;

            System.out.println("Quanto quer depositar?");

            deposito = scanner.nextDouble();

            System.out.println("Confirmar depósito?");
            System.out.println();
            System.out.println("1 - Confirmar");
            System.out.println("2 - Não confirmar");
            opcaoDeposito = scanner.nextInt();

            switch (opcaoDeposito) {

        case 1:

            saldo = saldo + deposito;

            System.out.println("Depósito confirmado!");
            System.out.println("Saldo atual: R$ " + saldo);

            break;
        
        case 2: 

            System.out.println("Depósito cancelado!");

            break;

        default:

            System.out.println("Selecione uma opção válida!");

            }

            break;

        case 5:

            System.out.println("Saindo do sistema...");

            break;

        default:

            System.out.println("Opção inválida!");

      }

     } while (opcao != 5);

    }
}

