public abstract class Produto {
    protected String nome;
    protected String validade;
    protected Double preco;
    protected int estoque;

    public Produto(String nome, String validade, Double preco, int estoque){
        this.nome = nome;
        this.validade = validade;
        this.preco = preco;
        this.estoque = estoque;
    }

    public abstract void cadastrar_produto();

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
