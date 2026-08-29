import java.util.Locale; // Importa a classe Locale para configurar padrões regionais (ex.: separador decimal com ponto)
import java.util.Scanner; // Importa a classe Scanner para ler dados digitados no console (teclado)

public class RelatorioDiarioLaboratorio { // Declara a classe principal do programa (o arquivo deve ter o mesmo nome)

    public static void main(String[] args) { // Método principal: ponto de entrada do programa (onde a execução começa)
        Locale.setDefault(Locale.US); // Define o padrão regional como US para usar ponto em números decimais (ex.: 3.50)

        Scanner entrada = new Scanner(System.in); // Cria um Scanner para ler dados da entrada padrão (teclado/console)

        System.out.println("=== Relatorio Diario Do Laboratorio ==="); // Imprime o título do programa e pula linha

        System.out.print("Quantidade De Amostras Processadas: "); // Solicita ao usuário a quantidade de amostras (não pula linha)
        int amostras = entrada.nextInt(); // Lê um inteiro digitado e armazena na variável amostras

        System.out.print("Tempo Total Gasto (Minutos): "); // Solicita ao usuário o tempo total gasto (pode ter casas decimais)
        double tempoTotalMin = entrada.nextDouble(); // Lê um double digitado e armazena em tempoTotalMin

        System.out.print("Numero De Resultados Validos: "); // Solicita ao usuário quantos resultados foram válidos
        int validos = entrada.nextInt(); // Lê um inteiro digitado e armazena na variável validos

        double tempoMedio = calcularTempoMedio(tempoTotalMin, amostras); // Chama função para calcular tempo médio por amostra
        double percentualValidos = calcularPercentualValidos(validos, amostras); // Chama função para calcular percentual de válidos

        System.out.println("\n=== Indicadores ==="); // Imprime uma linha em branco (\n) e o cabeçalho da seção de resultados
        System.out.println("Tempo Medio Por Amostra (min): " + formatar2Casas(tempoMedio)); // Exibe tempo médio formatado com 2 casas
        System.out.println("Percentual De Resultados Validos (%): " + formatar2Casas(percentualValidos)); // Exibe percentual formatado com 2 casas

        entrada.close(); // Fecha o Scanner para liberar recursos do sistema (boa prática)
    } // Fecha o método main

    public static double calcularTempoMedio(double tempoTotalMin, int amostras) { // Função para calcular a média de tempo por amostra
        return tempoTotalMin / amostras; // Divide o tempo total pelo número de amostras e retorna o resultado (double)
    } // Fecha a função calcularTempoMedio

    public static double calcularPercentualValidos(int validos, int amostras) { // Função para calcular o percentual de resultados válidos
        double razaoValidos = validos / (double) amostras; // Converte amostras para double para evitar divisão inteira (truncamento)
        return razaoValidos * 100.0; // Converte a razão (0 a 1) em percentual (0 a 100) e retorna
    } // Fecha a função calcularPercentualValidos

    public static String formatar2Casas(double valor) { // Função para formatar um número com 2 casas decimais para impressão
        return String.format(Locale.US, "%.2f", valor); // Formata com 2 casas decimais usando Locale.US (ponto como separador)
    } // Fecha a função formatar2Casas
} // Fecha a classe RelatorioDiarioLaboratorio
