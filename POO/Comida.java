import java.util.ArrayList;
import java.util.Scanner;

public class Comida extends Alimento {
    protected String peso;
    private static ArrayList<Comida> listaComidas = new ArrayList<>();

    public Comida(String nome, String validade, double preco, int estoque, String marca, String categoria, String peso) {
        super(nome, validade, preco, estoque, marca, categoria);
        this.peso = peso;
    }

    public void cadastrar_produto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Comida ===");

        System.out.print("Nome: ");
        nome = scanner.nextLine();

        System.out.print("Validade: ");
        validade = scanner.nextLine();

        System.out.print("Preço: ");
        preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("Estoque: ");
        estoque = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("Marca: ");
        marca = scanner.nextLine();

        System.out.print("Categoria: ");
        categoria = scanner.nextLine();

        System.out.print("Peso: ");
        peso = scanner.nextLine();

        Comida comida = new Comida(nome, validade, preco, estoque, marca, categoria, peso);
        listaComidas.add(comida);

        System.out.println("Comida cadastrada com sucesso!");
    }

    public static void imprimirListaComidas() {
        for (Comida comida : listaComidas) {
            System.out.println(comida.toString());
        }
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nValidade: " + validade +
                "\nPreço: " + preco +
                "\nEstoque: " + estoque +
                "\nMarca: " + marca +
                "\nCategoria: " + categoria +
                "\nPeso: " + peso +
                "\n----------------------";
    }
}