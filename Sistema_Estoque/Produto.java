package Sistema_Estoque;
public class Produto {

    String nome;
    double preco;
    int quantidade;
    String categoria;

public Produto(String nome, double preco, int quantidade, String categoria) {
    this.nome = nome;
    this.preco = preco;
    this.quantidade = quantidade;
    this.categoria = categoria;
}

public void exibirInformacoes() {
    System.out.println(this.nome + " | R$ " + this.preco + " | " + this.quantidade + " un | " + this.categoria);
    }
}
