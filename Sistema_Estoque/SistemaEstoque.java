package Sistema_Estoque;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEstoque {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int opcao; 

        ArrayList<Produto> estoque = new ArrayList<>();

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch(opcao) {

                case 1: 
                    cadastrarProduto(scanner, estoque);
                    break;

                case 2:
                    listarProdutos(estoque);
                    break;

                case 3:
                    buscarProduto(scanner, estoque);
                    break;

                case 4:
                    alterarProduto(scanner, estoque);
                    break;

                case 5: 
                    removerProduto(scanner, estoque);
                    break;

                case 6:
                    registrarEntrada(scanner, estoque);
                    break;

                case 7:
                    registrarSaida(scanner, estoque);
                    break;

                case 8:
                    exibirRelatorio(estoque);
                    break;

                case 9: 
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 9); 

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n===============");
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
        System.out.print("Opção: ");
    }

    public static void cadastrarProduto(Scanner scanner, ArrayList<Produto> estoque) {
        scanner.nextLine();

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine(); 

        System.out.println("Digite o preço:");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite a categoria:");
        String categoria = scanner.nextLine();

        estoque.add(new Produto(nome, preco, quantidade, categoria));

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos(ArrayList<Produto> estoque) {
        if (estoque.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

    for (Produto p : estoque) {
        p.exibirInformacoes();
    }
}

    public static void buscarProduto(Scanner scanner, ArrayList<Produto> estoque) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto desejado:");
        String busca = scanner.nextLine();

        int indice = localizarIndiceProduto(estoque, busca);

        if (indice != -1) {
            estoque.get(indice).exibirInformacoes();
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public static int localizarIndiceProduto(ArrayList<Produto> estoque, String nomeProcurado) {
        for (int i = 0; i < estoque.size(); i++) {
            if (nomeProcurado.equalsIgnoreCase(estoque.get(i).nome)) {
                return i;
            }
        } 
        return -1;
    }

    public static void alterarProduto(Scanner scanner, ArrayList<Produto> estoque) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto que deseja alterar:");
        String produtoProcurado = scanner.nextLine();

        int indice = localizarIndiceProduto(estoque, produtoProcurado);

        if (indice != -1) {
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.nextLine();

            System.out.println("Digite o novo preço:");
            double novoPreco = scanner.nextDouble();

            System.out.println("Digite a nova quantidade:");
            int novaQuantidade = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Digite a nova categoria:");
            String novaCategoria = scanner.nextLine();

            estoque.set(indice, new Produto(novoNome, novoPreco, novaQuantidade, novaCategoria));

            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void removerProduto(Scanner scanner, ArrayList<Produto> estoque) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto que deseja remover:");
        String produtoExcluir = scanner.nextLine();

        int indice = localizarIndiceProduto(estoque, produtoExcluir);

        if (indice != -1) {
            estoque.remove(indice);

            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void registrarEntrada(Scanner scanner, ArrayList<Produto> estoque) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto:");
        String produtoEntrada = scanner.nextLine(); 

        int indice = localizarIndiceProduto(estoque, produtoEntrada);

        if (indice != -1) { 
            System.out.println("Digite a quantidade de entrada:");
            int quantidade = scanner.nextInt();

            if (quantidade > 0) {
                estoque.get(indice).quantidade += quantidade;

                System.out.println("Entrada registrada com sucesso!");
            } else {
                System.out.println("Quantidade inválida!");
            }
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void registrarSaida(Scanner scanner, ArrayList<Produto> estoque) {
        scanner.nextLine();
        System.out.println("Digite o nome do produto:");
        String produtoSaida = scanner.nextLine();

        int indice = localizarIndiceProduto(estoque, produtoSaida);

        if (indice != -1) {
            System.out.println("Digite a quantidade de saída:");
            int valorSaida = scanner.nextInt();

            if (valorSaida > 0 && valorSaida <= estoque.get(indice).quantidade) {
                estoque.get(indice).quantidade -= valorSaida;

                System.out.println("Saída registrada com sucesso!");
            } else {
                System.out.println("Quantidade inválida ou estoque insuficiente!");
            }
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void exibirRelatorio(ArrayList<Produto> estoque) {
        int totalUnidades = 0;

        for (Produto p : estoque) {
            totalUnidades += p.quantidade;
        }

        System.out.println("\n========== RELATÓRIO DE ESTOQUE ==========");
        System.out.println("Produtos cadastrados: " + estoque.size());
        System.out.println("Total de unidades: " + totalUnidades);
        System.out.println();
        System.out.println("Produtos com estoque baixo:");

        boolean baixo = false;

        for (Produto p : estoque) {
            if (p.quantidade <= 5) {
                baixo = true;
                System.out.println(p.nome + " - " + p.quantidade + " un");
            }
        }

        if (!baixo) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }

}