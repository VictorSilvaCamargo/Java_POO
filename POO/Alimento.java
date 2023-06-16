public abstract class Alimento extends Produto {
    protected String marca;
    protected String categoria;

    public Alimento(String nome, String validade, double preco, int estoque, String marca, String categoria){
        super(nome, validade, preco, estoque);
        this.marca = marca;
        this.categoria = categoria;
    }

    public void cadastrar_produto() {
    }

}
