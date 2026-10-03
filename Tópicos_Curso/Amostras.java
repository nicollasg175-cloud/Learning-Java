package Tópicos_Curso;
import java.util.Scanner;

public class Amostras {

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

     // Dados     
     int amostras = 120;
     int validos = 114;
     double tempoTotalMin = 360.0;

     double tempoMedio;
     double percentual;

System.out.println("Digite o tempo total:");
tempoTotalMin = scanner.nextDouble(); 

System.out.println("Digite a quantidade de amostras:");
amostras = scanner.nextInt();

System.out.println("Digite a quantidade de amostras válidas:");
validos = scanner.nextInt();

// Cálculos
tempoMedio = tempoTotalMin / amostras;

percentual = (double) validos / amostras * 100;

// Cálculos
System.out.println("Tempo Medio Por Amostra (min): " + String.format("%.2f", tempoMedio));

System.out.println("Percentual De Resultados Validos (%): " + String.format("%.2f", percentual));

    }
}