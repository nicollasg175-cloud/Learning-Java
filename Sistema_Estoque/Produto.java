public class Produto {

    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;

    public Produto(String nome, double preco, int quantidade, String categoria) {
        this.nome = nome;
        setPreco(preco);
        setQuantidade(quantidade);
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: O preço do produto '" + this.nome + "' não pode ser negativo!");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Erro: A quantidade do produto '" + this.nome + "' não pode ser negativa!");
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void exibirInformacoes() {
        System.out.println(this.nome + " | R$ " + this.preco + " | " + this.quantidade + " un | " + this.categoria);
    }

    public void adicionarEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidade += qtd;
            System.out.println("Entrada de " + qtd + " unidade(s) registrada com sucesso!");
        } else {
            System.out.println("Erro: A quantidade para entrada deve ser maior que zero!");
        }
    }

    public void removerEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Erro: A quantidade para saída deve ser maior que zero!");
        } else if (qtd <= this.quantidade) {
            this.quantidade -= qtd;
            System.out.println("Saída de " + qtd + " unidade(s) registrada com sucesso!");
        } else {
            System.out.println("Erro: Quantidade insuficiente em estoque! Disponível: " + this.quantidade);
        }
    }
}
