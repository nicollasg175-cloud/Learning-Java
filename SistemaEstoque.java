import java.util.Scanner;

public class SistemaEstoque {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int opcao; 

    String[] nomes = new String[10];
    double[] precos = new double[10];
    int[] quantidades = new int[10];
    String[] categorias = new String[10];

    int totalProdutos = 0;

do {

    System.out.println("===============");
    System.out.println("SISTEMA ESTOQUE");
    System.out.println("===============");
    System.out.println("1 - Cadastrar produto");
    System.out.println("2 - Listar produtos");
    System.out.println("3 - Buscar produto");
    System.out.println("4 - Alterar produto");
    System.out.println("5 - Remover produto");
    System.out.println("6 - Registrar entrada");
    System.out.println("7 - Registrar saída");
    System.out.println("8 - Ver estoque");
    System.out.println("9 - Sair");

    opcao = scanner.nextInt();

switch(opcao) {

case 1: 

    String nome;
    double preco;
    int quantidade;
    String categoria;

    scanner.nextLine(); // Limpa o ENTER do menu

    System.out.println("Digite o nome:");
        nome = scanner.nextLine();

    System.out.println("Digite o preço:");
        preco = scanner.nextDouble();

    System.out.println("Digite a quantidade:");
        quantidade = scanner.nextInt();

        scanner.nextLine(); // Limpa buffer

    System.out.println("Digite a categoria:");
        categoria = scanner.nextLine();

    nomes[totalProdutos] = nome;
    precos[totalProdutos] = preco;
    quantidades[totalProdutos] = quantidade;
    categorias[totalProdutos] = categoria;

    totalProdutos++;

    System.out.println("Produto cadastrado com sucesso!");

        break;

case 2:

        if (totalProdutos == 0) {
    System.out.println("Nenhum produto cadastrado!");
    }
        for (int i = 0; i < totalProdutos; i++) {
    System.out.println(nomes[i] + " | R$ " + precos[i] + " | " + quantidades[i] + " un | " + categorias[i]);
    }

        break;

case 3:

        String busca;

    System.out.println("Digite o nome do produto desejado:");

        scanner.nextLine(); // limpa o ENTER do menu
        
        busca = scanner.nextLine();

        boolean encontrou = false;

for (int i = 0; i < totalProdutos; i++) {

if (busca.equals(nomes[i])) {

        encontrou = true;

    System.out.println(nomes[i] + " | R$ " + precos[i] + " | " + quantidades[i] + " un | " + categorias[i]);
            
            }
    }   

if (!encontrou) {
        System.out.println("Produto não encontrado!");
    }

        break;

case 4:

        String alterar;

        scanner.nextLine();

    System.out.println("Digite o nome do produto que deseja alterar:");
        alterar = scanner.nextLine();

        int indiceEncontrado = -1;

for (int i = 0; i < totalProdutos; i++) {

if (alterar.equals(nomes[i])) {

    indiceEncontrado = i;

    }
}

if (indiceEncontrado != -1 ) {

        String novoNome;
        double novoPreco;
        int novaQuantidade;
        String novaCategoria;

    System.out.println("Digite o novo nome:");
        novoNome = scanner.nextLine();

    System.out.println("Digite o novo preço:");
        novoPreco = scanner.nextDouble();

    System.out.println("Digite a nova quantidade:");
        novaQuantidade = scanner.nextInt();

        scanner.nextLine(); // Limpa o ENTER do int quantidade 

    System.out.println("Digite a nova categoria");
        novaCategoria = scanner.nextLine();

        nomes[indiceEncontrado] = novoNome;
        precos[indiceEncontrado] = novoPreco;
        quantidades[indiceEncontrado] = novaQuantidade;
        categorias[indiceEncontrado] = novaCategoria;

    System.out.println("Produto alterado com sucesso!");

} else {

    System.out.println("Produto inexistente!");

}

        break;

case 5: 

        String excluir;

        scanner.nextLine();

    System.out.println("Digite o nome do produto que deseja remover:");
        excluir = scanner.nextLine();

        indiceEncontrado = -1;

for (int i = 0; i < totalProdutos; i++) {

if (excluir.equals(nomes[i])) {

        indiceEncontrado = i;

    }
}

if (indiceEncontrado != -1) {

for (int i = indiceEncontrado + 1; i < totalProdutos; i++) {

    nomes[i - 1] = nomes[i];
    precos[i - 1] = precos[i];
    quantidades[i - 1] = quantidades[i];
    categorias[i - 1] = categorias[i];

}

    totalProdutos--;

    nomes[totalProdutos] = null;
    precos[totalProdutos] = 0;
    quantidades[totalProdutos] = 0;
    categorias[totalProdutos] = null;

}

if (indiceEncontrado != -1) {

    System.out.println("Item removido com sucesso!");

} else {

    System.out.println("Produto não encontrado!");

}

        break;

case 6:

        String nomeEntrada;

        scanner.nextLine();

    System.out.println("Digite o nome do produto:");
        nomeEntrada = scanner.nextLine();

        indiceEncontrado = -1;

for (int i = 0; i < totalProdutos; i++) {

if (nomeEntrada.equals(nomes[i])) {

        indiceEncontrado = i;
    }
}

        int valorEntrada;

if (indiceEncontrado != -1) {

    System.out.println("Digite a quantidade de entrada:");
        valorEntrada = scanner.nextInt();

if ( valorEntrada > 0) {

    quantidades[indiceEncontrado] = quantidades[indiceEncontrado] + valorEntrada;

    System.out.println("Entrada concluída com sucesso!");

} else {

    System.out.println("Digite um valor válido!");

    }

} else {

    System.out.println("Produto não encontrado!");
    
}

        break;

case 7:

        String produtoSaida;

        scanner.nextLine();

        System.out.println("Digite o nome do produto:");
            produtoSaida = scanner.nextLine();

        indiceEncontrado = -1;

for (int i = 0; i < totalProdutos; i++) {

if (produtoSaida.equals(nomes[i])) {

        indiceEncontrado = i;

    }

}

        int valorSaida;

if (indiceEncontrado != -1) {

     System.out.println("Digite o valor da saída:");
            valorSaida = scanner.nextInt();

if (valorSaida <= quantidades[indiceEncontrado]) {

if (valorSaida > 0) {

    quantidades[indiceEncontrado] = quantidades[indiceEncontrado] - valorSaida;

        System.out.println("Valor removido com sucesso!");

} else {

        System.out.println("Quantidade inválida!");

        }

} else {

        System.out.println("Quantidade inválida!");

    }

} else {

        System.out.println("Produto não encontrado!");

}

        break;

case 8:

        int totalUn = 0;

for (int i = 0; i < totalProdutos; i++) {

    totalUn = totalUn + quantidades[i];

}

        System.out.println("========== RELATÓRIO DE ESTOQUE ==========");

            System.out.println("Produtos cadastrados: " + totalProdutos);

                System.out.println("Total de unidades: " + totalUn);

                    System.out.println();

                System.out.println("Produtos com estoque baixo:");

            boolean baixo = false;

for (int i = 0; i < totalProdutos; i++) {

if (quantidades[i] <= 5) {

    baixo = true;

    System.out.println(nomes[i] + " - " + quantidades[i]);

    }
}

if (!baixo) {

    System.out.println("Nenhum produto com estoque baixo.");

}

        break;

case 9: 

        System.out.println("Saindo do sistema...");

        break;

default:

        System.out.println("Opção inválida!");
}

} while (opcao != 9); 

    } 

}