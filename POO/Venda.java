import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Venda {
    protected String data;
    protected String nome_caixa;
    protected String nome_cliente;
    protected ArrayList<Produto> carrinho;
    protected Double valor_total;

    public Venda(String data, String nome_caixa, String nome_cliente, ArrayList<Produto> carrinho, Double valor_total) {
        this.data = data;
        this.nome_caixa = nome_caixa;
        this.nome_cliente = nome_cliente;
        this.carrinho = carrinho;
        this.valor_total = valor_total;
    }

    public static void criar_venda(String data, String nome_caixa, String nome_cliente, ArrayList<Produto> carrinho, double valor_total) {
        try {
            FileWriter writer = new FileWriter("nota_fiscal.txt");
            writer.write("Data: " + data + "\n");
            writer.write("Caixa: " + nome_caixa + "\n");
            writer.write("Cliente: " + nome_cliente + "\n");
            writer.write("Produtos:\n");

            for (Produto produto : carrinho) {
                writer.write("- " + produto.getNome() + " - R$ " + produto.getPreco() + "\n");
            }

            writer.write("Valor Total: R$ " + valor_total + "\n");

            writer.close();
            System.out.println("Nota fiscal gerada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gerar a nota fiscal: " + e.getMessage());
        }
    }

}
