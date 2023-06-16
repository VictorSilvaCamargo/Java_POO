import java.util.ArrayList;
import java.util.Scanner;

public class Bebida extends Alimento {
    protected String volume;
    private static ArrayList<Bebida> listaBebidas = new ArrayList<>();

    public Bebida(String nome, String validade, double preco, int estoque, String marca, String categoria, String volume) {
        super(nome, validade, preco, estoque, marca, categoria);
        this.volume = volume;
    }

    public  void cadastrar_produto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Bebida ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Validade: ");
        String validade = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Volume: ");
        String volume = scanner.nextLine();

        Bebida bebida = new Bebida(nome, validade, preco, estoque, marca, categoria, volume);
        listaBebidas.add(bebida);

        System.out.println("Bebida cadastrada com sucesso!");
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nValidade: " + validade +
                "\nPreço: " + preco +
                "\nEstoque: " + estoque +
                "\nMarca: " + marca +
                "\nCategoria: " + categoria +
                "\nVolume: " + volume +
                "\n----------------------";
    }
}
