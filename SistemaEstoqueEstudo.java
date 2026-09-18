import java.util.Scanner;

public class SistemaEstoqueEstudo {

    public static void main(String[] args) {
        
        // Instância do Scanner para leitura de dados via terminal
        Scanner scanner = new Scanner(System.in);

        int opcao; 

        // Estrutura de memória utilizando Arrays Paralelos (capacidade fixa para 10 itens)
        String[] nomes = new String[10];
        double[] precos = new double[10];
        int[] quantidades = new int[10];
        String[] categorias = new String[10];

        // Variável de controle do total de produtos cadastrados atualmente
        int totalProdutos = 0;

        // Loop principal do menu interativo
        do {
            exibirMenu(); // Desenha a interface do menu no terminal
            opcao = scanner.nextInt();

            switch(opcao) {

                case 1: 
                    // Cadastra um novo produto e atualiza a contagem geral
                    totalProdutos = cadastrarProduto(scanner, nomes, precos, quantidades, categorias, totalProdutos);
                    break;

                case 2:
                    // Exibe a lista completa de produtos cadastrados
                    listarProdutos(nomes, precos, quantidades, categorias, totalProdutos);
                    break;

                case 3:
                    // Pesquisa e exibe os dados de um produto específico
                    buscarProduto(scanner, nomes, precos, quantidades, categorias, totalProdutos);
                    break;

                case 4:
                    // Altera as informações de um produto existente
                    alterarProduto(scanner, nomes, precos, quantidades, categorias, totalProdutos);
                    break;

                case 5: 
                    // Remove um produto, reorganiza os arrays e atualiza a contagem geral
                    totalProdutos = removerProduto(scanner, nomes, precos, quantidades, categorias, totalProdutos);
                    break;

                case 6:
                    // Adiciona novas unidades ao estoque de um produto existente
                    registrarEntrada(scanner, nomes, quantidades, totalProdutos);
                    break;

                case 7:
                    // Subtrai unidades do estoque de um produto existente
                    registrarSaida(scanner, nomes, quantidades, totalProdutos);
                    break;
                    
                case 8:
                    // Exibe o relatório consolidades do estoque e alertas de estoque baixo
                    exibirRelatorio(nomes, quantidades, totalProdutos);
                    break;

                case 9: 
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 9); 

        scanner.close(); // Encerra o objeto Scanner ao sair do loop
    } // Fim do método main

    // =========================================================================
    // MÉTODOS AUXILIARES E REGRAS DE NEGÓCIO
    // =========================================================================

    /**
     * Imprime as opções do menu no terminal.
     * Retorno: void (apenas exibe informações, não devolve valor).
     */
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

    /**
     * Insere um novo produto nos arrays paralelos.
     * Retorno: int (retorna a nova quantidade total de produtos cadastrados).
     */
    public static int cadastrarProduto(Scanner scanner, String[] nomes, double[] precos, int[] quantidades, String[] categorias, int totalProdutos) {
        // Valida se o array atingiu o limite de armazenamento (10 itens)
        if (totalProdutos >= nomes.length) {
            System.out.println("Estoque cheio! Não é possível cadastrar mais produtos.");
            return totalProdutos;
        }

        scanner.nextLine(); // Limpa a quebra de linha (ENTER) deixada pelo nextInt()

        System.out.println("Digite o nome:");
        String nome = scanner.nextLine(); 

        System.out.println("Digite o preço:");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();

        scanner.nextLine(); // Limpa o buffer antes da leitura da String

        System.out.println("Digite a categoria:");
        String categoria = scanner.nextLine();

        // Atribui os dados nas posições correspondentes do índice 'totalProdutos'
        nomes[totalProdutos] = nome;
        precos[totalProdutos] = preco;
        quantidades[totalProdutos] = quantidade;
        categorias[totalProdutos] = categoria;

        totalProdutos++; // Incrementa o contador de produtos cadastrados

        System.out.println("Produto cadastrado com sucesso!");

        return totalProdutos; // Devolve a contagem atualizada para a variável do main
    }

    /**
     * Percorre os arrays e imprime os dados de todos os produtos cadastrados.
     * Retorno: void.
     */
    public static void listarProdutos(String[] nomes, double[] precos, int[] quantidades, String[] categorias, int totalProdutos) {
        if (totalProdutos == 0) {
            System.out.println("Nenhum produto cadastrado!");
            return; // Interrompe e sai do método precocemente se não houver itens
        }

        for (int i = 0; i < totalProdutos; i++) {
            System.out.println(nomes[i] + " | R$ " + precos[i] + " | " + quantidades[i] + " un | " + categorias[i]);
        }
    }

    /**
     * Localiza um produto e imprime seus dados detalhados.
     * Retorno: void.
     */
    public static void buscarProduto(Scanner scanner, String[] nomes, double[] precos, int[] quantidades, String[] categorias, int totalProdutos) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto desejado:");
        String busca = scanner.nextLine();

        // Reutiliza o motor de busca para encontrar o índice
        int indice = localizarIndiceProduto(nomes, totalProdutos, busca);

        if (indice != -1) {
            System.out.println(nomes[indice] + " | R$ " + precos[indice] + " | " + quantidades[indice] + " un | " + categorias[indice]);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    /**
     * MOTOR DE BUSCA
     * Procura a posição de um produto no array pelo nome.
     * Retorno: int (índice da posição encontrada entre 0 e totalProdutos - 1, ou -1 caso não exista).
     */
    public static int localizarIndiceProduto(String[] nomes, int totalProdutos, String nomeProcurado) {
        for (int i = 0; i < totalProdutos; i++) {
            // Compara ignorando diferenças entre letras maiúsculas e minúsculas
            if (nomeProcurado.equalsIgnoreCase(nomes[i])) {
                return i; // Retorna o índice e encerra a execução do método imediatamente
            }
        } 
        return -1; // Retorno retornado caso o loop chegue ao fim sem encontrar partidas
    }

    /**
     * Sobrescreve as informações de um produto existente.
     * Retorno: void (não altera a quantidade total de itens cadastrados).
     */
    public static void alterarProduto(Scanner scanner, String[] nomes, double[] precos, int[] quantidades, String[] categorias, int totalProdutos) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto que deseja alterar:");
        String produtoProcurado = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, totalProdutos, produtoProcurado);

        if (indice != -1) {
            System.out.println("Digite o novo nome:");
            nomes[indice] = scanner.nextLine();

            System.out.println("Digite o novo preço:");
            precos[indice] = scanner.nextDouble();

            System.out.println("Digite a nova quantidade:");
            quantidades[indice] = scanner.nextInt();

            scanner.nextLine(); // Limpa o buffer do scanner

            System.out.println("Digite a nova categoria:");
            categorias[indice] = scanner.nextLine();

            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    /**
     * Apaga um produto e reordena os elementos dos arrays paralelos à esquerda (shift).
     * Retorno: int (devolve o totalProdutos reduzido).
     */
    public static int removerProduto(Scanner scanner, String[] nomes, double[] precos, int[] quantidades, String[] categorias, int totalProdutos) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto que deseja remover:");
        String produtoExcluir = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, totalProdutos, produtoExcluir);

        if (indice != -1) {
            // Desloca todos os elementos à direita do item removido uma posição para a esquerda
            for (int i = indice + 1; i < totalProdutos; i++) {
                nomes[i - 1] = nomes[i];
                precos[i - 1] = precos[i];
                quantidades[i - 1] = quantidades[i];
                categorias[i - 1] = categorias[i];
            }

            totalProdutos--; // Decrementa o contador total de itens

            // Limpa as referências salvas no último slot desocupado
            nomes[totalProdutos] = null;
            precos[totalProdutos] = 0;
            quantidades[totalProdutos] = 0;
            categorias[totalProdutos] = null;

            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }

        return totalProdutos; // Retorna o novo valor para o main
    }

    /**
     * Incrementa a quantidade em estoque de um item existente.
     * Retorno: void.
     */
    public static void registrarEntrada(Scanner scanner, String[] nomes, int[] quantidades, int totalProdutos) {
        scanner.nextLine(); 
        System.out.println("Digite o nome do produto:");
        String produtoEntrada = scanner.nextLine(); 

        int indice = localizarIndiceProduto(nomes, totalProdutos, produtoEntrada);

        if (indice != -1) { 
            System.out.println("Digite a quantidade de entrada:");
            int quantidade = scanner.nextInt();

            if (quantidade > 0) {
                quantidades[indice] += quantidade; // Soma ao valor armazenado
                System.out.println("Entrada registrada com sucesso!");
            } else {
                System.out.println("Quantidade inválida!");
            }
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    /**
     * Decrementa a quantidade em estoque após validação de saldo suficiente.
     * Retorno: void.
     */
    public static void registrarSaida(Scanner scanner, String[] nomes, int[] quantidades, int totalProdutos) {
        scanner.nextLine();
        System.out.println("Digite o nome do produto:");
        String produtoSaida = scanner.nextLine();

        int indice = localizarIndiceProduto(nomes, totalProdutos, produtoSaida);

        if (indice != -1) {
            System.out.println("Digite a quantidade de saída:");
            int valorSaida = scanner.nextInt();

            if (valorSaida > 0 && valorSaida <= quantidades[indice]) {
                quantidades[indice] -= valorSaida; // Subtrai do valor armazenado
                System.out.println("Saída registrada com sucesso!");
            } else {
                System.out.println("Quantidade inválida ou estoque insuficiente!");
            }
        } else {
            System.out.println("Produto não encontrado no sistema!");
        }
    }

    /**
     * Calcula totalizadores do sistema e lista alertas de estoque baixo (<= 5).
     * Retorno: void.
     */
    public static void exibirRelatorio(String[] nomes, int[] quantidades, int totalProdutos) {
        int totalUnidades = 0;

        // Calcula a soma total de unidades de todos os produtos
        for (int i = 0; i < totalProdutos; i++) {
            totalUnidades += quantidades[i];
        }

        System.out.println("\n========== RELATÓRIO DE ESTOQUE ==========");
        System.out.println("Produtos cadastrados: " + totalProdutos);
        System.out.println("Total de unidades: " + totalUnidades);
        System.out.println();
        System.out.println("Produtos com estoque baixo:");

        boolean baixo = false;

        // Filtra e exibe os produtos com estoque menor ou igual a 5 unidades
        for (int i = 0; i < totalProdutos; i++) {
            if (quantidades[i] <= 5) {
                baixo = true;
                System.out.println(nomes[i] + " - " + quantidades[i] + " un");
            }
        }

        if (!baixo) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }

} // Fim da classe SistemaEstoque