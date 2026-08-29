import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome");
        String nome = scanner.nextLine();

        System.out.println("Digite seu peso:");
        double peso = scanner.nextDouble();

        System.out.println("Digite sua altura:");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);

        System.out.println(nome);
        System.out.printf("Seu IMC é %.2f\n", imc);

    }
}