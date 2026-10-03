package Tópicos_Curso;
import java.util.Scanner; 

public class TreinoJava {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nome;
        int idade;
        double salario;

        System.out.println("Qual o seu nome?");
        nome = scanner.nextLine();

        System.out.println("Quantos anos você tem?");
        idade = scanner.nextInt();

        System.out.println("Quanto é o seu salário?");
        salario = scanner.nextDouble();

        System.out.println("===Cadastro===");

        System.out.println("Seu nome é " + nome);
        System.out.println("Você tem " + idade + " anos");
        System.out.println("Você recebe R$ " + salario);

        if (idade >= 18) { 
            System.out.println("Você é maior de idade"); 
        } else { 
            System.out.println("Você é menor de idade");
        }

        if (salario >= 7000) {

            System.out.println("Renda muito alta");

        } else if (salario >= 4000) {

            System.out.println("Renda alta");

        } else if (salario >= 2000) {

            System.out.println("Renda média");

        } else {

            System.out.println("Renda baixa");
        }

        int opcao;


        System.out.println();
        System.out.println("===== MENU =====");
        System.out.println();
        System.out.println("1 - Ver cadastro");
        System.out.println("2 - Calcular salário anual");
        System.out.println("3 - Ver classificação");
        System.out.println("4 - Sair");


        System.out.println("Escolha uma opção:");
        opcao = scanner.nextInt();

        switch (opcao) {

        case 1: 
            System.out.println("Seu nome é " + nome);
            System.out.println("Você tem " + idade + " anos");
            System.out.println("Você recebe R$ " + salario);

            break;

        case 2: 
            System.out.printf("Você recebe R$ %.2f por ano.%n", salario * 12);

            break;

        case 3:
           System.out.println("Sua classificação de renda é:");

            if (salario >= 7000) {

            System.out.println("Renda muito alta");

        } else if (salario >= 4000) {

            System.out.println("Renda alta");

        } else if (salario >= 2000) {

            System.out.println("Renda média");

        } else {

            System.out.println("Renda baixa");
        }
        break;

        case 4: 
            System.out.println("Saindo...");

        break;

        }

    }
}