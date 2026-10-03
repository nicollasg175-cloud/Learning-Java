package Tópicos_Curso;
import java.util.Scanner;

public class Codigo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double reserva, saldo = 0; 

        System.out.println("Qual seu nome?"); 
        String nome = scanner.nextLine();

        System.out.println("Qual a sua idade?"); 
        int idade = scanner.nextInt();
        scanner.nextLine(); // LIMPA BUFFER 

        System.out.println("Qual setor você trabalha");
        String trabalho = scanner.nextLine();

        System.out.println("Quanto você recebe por mês?");
        double salario = scanner.nextDouble();

        System.out.println("\n--- RESUMO ---");
        System.out.println("Seu nome é: " + nome); 
        System.out.println("Você tem: " + idade + " anos"); 
        System.out.println("Você trabalha no ramo da " + trabalho);
        System.out.println("Você recebe " + salario + "por mês");

          
    }
}