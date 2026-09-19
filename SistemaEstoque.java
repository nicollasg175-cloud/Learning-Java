import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEstoque {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int opcao; 

        // Listas dinâmicas com ArrayList
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        ArrayList<String> categorias = new ArrayList<>();

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch(opcao) {

                case 1: 
                    cadastrarProduto(scanner, nomes, precos, quantidades, categorias);
                    break;

                case 2:
                    listarProdutos(nomes, precos, quantidades, categorias);
                    break;

                case 3:
                    buscarProduto(scanner, nomes, precos, quantidades, categorias);
                    break;

                case 4:
                    alterarProduto(scanner, nomes, precos, quantidades, categorias);
                    break;

                case 5: 
                    removerProduto(scanner, nomes, precos, quantidades, categorias);
                    break;

                case 6:
                    registrarEntrada(scanner, nomes, quantidades);
                    break;

                case 7:
                    registrarSaida(scanner, nomes, quantidades);
                    break;

                case 8:
                    exibirRelatorio(nomes, quantidades);
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

    public static void cadastrarProduto(Scanner scanner, ArrayList<String> nomes, ArrayList<Double> precos, ArrayList<Integer> quantidades, ArrayList<String> categorias) {
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

        nomes.add(nome);
        precos.add(preco);
        quantidades.add(quantidade);
        categorias.add(categoria);

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void listarProdutos(ArrayList<String> nomes, ArrayList<Double> precos, ArrayList<Integer> quantidades, ArrayList<String> categorias) {
        if (nomes.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i) + " | R$ " + precos.get(i) + " | " + quantidades.get(i) + " un | " + categorias.get(i));
        }
    }

    public static void buscarProduto(Scanner scanner, ArrayList<String> nomes, ArrayList<Double> precos, ArrayList<Integer> quantidades, ArrayList<String> categorias) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto desejado:");
        String busca = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, busca);

        if (indice != -1) {
            System.out.println(nomes.get(indice) + " | R$ " + precos.get(indice) + " | " + quantidades.get(indice) + " un | " + categorias.get(indice));
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public static int localizarIndiceProduto(ArrayList<String> nomes, String nomeProcurado) {
        for (int i = 0; i < nomes.size(); i++) {
            if (nomeProcurado.equalsIgnoreCase(nomes.get(i))) {
                return i;
            }
        } 
        return -1;
    }

    public static void alterarProduto(Scanner scanner, ArrayList<String> nomes, ArrayList<Double> precos, ArrayList<Integer> quantidades, ArrayList<String> categorias) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto que deseja alterar:");
        String produtoProcurado = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, produtoProcurado);

        if (indice != -1) {
            System.out.println("Digite o novo nome:");
            nomes.set(indice, scanner.nextLine());

            System.out.println("Digite o novo preço:");
            precos.set(indice, scanner.nextDouble());

            System.out.println("Digite a nova quantidade:");
            quantidades.set(indice, scanner.nextInt());

            scanner.nextLine();

            System.out.println("Digite a nova categoria:");
            categorias.set(indice, scanner.nextLine());

            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void removerProduto(Scanner scanner, ArrayList<String> nomes, ArrayList<Double> precos, ArrayList<Integer> quantidades, ArrayList<String> categorias) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto que deseja remover:");
        String produtoExcluir = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, produtoExcluir);

        if (indice != -1) {
            nomes.remove(indice);
            precos.remove(indice);
            quantidades.remove(indice);
            categorias.remove(indice);

            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void registrarEntrada(Scanner scanner, ArrayList<String> nomes, ArrayList<Integer> quantidades) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto:");
        String produtoEntrada = scanner.nextLine(); 

        int indice = localizarIndiceProduto(nomes, produtoEntrada);

        if (indice != -1) { 
            System.out.println("Digite a quantidade de entrada:");
            int quantidade = scanner.nextInt();

            if (quantidade > 0) {
                int novaQuantidade = quantidades.get(indice) + quantidade;
                quantidades.set(indice, novaQuantidade);

                System.out.println("Entrada registrada com sucesso!");
            } else {
                System.out.println("Quantidade inválida!");
            }
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void registrarSaida(Scanner scanner, ArrayList<String> nomes, ArrayList<Integer> quantidades) {
        scanner.nextLine();
        System.out.println("Digite o nome do produto:");
        String produtoSaida = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, produtoSaida);

        if (indice != -1) {
            System.out.println("Digite a quantidade de saída:");
            int valorSaida = scanner.nextInt();

            if (valorSaida > 0 && valorSaida <= quantidades.get(indice)) {
                int novaQuantidade = quantidades.get(indice) - valorSaida;
                quantidades.set(indice, novaQuantidade);

                System.out.println("Saída registrada com sucesso!");
            } else {
                System.out.println("Quantidade inválida ou estoque insuficiente!");
            }
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    public static void exibirRelatorio(ArrayList<String> nomes, ArrayList<Integer> quantidades) {
        int totalUnidades = 0;

        for (int i = 0; i < quantidades.size(); i++) {
            totalUnidades += quantidades.get(i);
        }

        System.out.println("\n========== RELATÓRIO DE ESTOQUE ==========");
        System.out.println("Produtos cadastrados: " + nomes.size());
        System.out.println("Total de unidades: " + totalUnidades);
        System.out.println();
        System.out.println("Produtos com estoque baixo:");

        boolean baixo = false;

        for (int i = 0; i < quantidades.size(); i++) {
            if (quantidades.get(i) <= 5) {
                baixo = true;
                System.out.println(nomes.get(i) + " - " + quantidades.get(i) + " un");
            }
        }

        if (!baixo) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }

}