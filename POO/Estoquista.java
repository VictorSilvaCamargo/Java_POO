import java.util.ArrayList;
import java.util.Scanner;

public class Estoquista extends Funcionario implements Salario {
    protected Double horas_trabalhadas;
    private static ArrayList<Estoquista> listaEstoquistas = new ArrayList<>();

    public Estoquista(String nome, String ocupacao, Double salario, int id, Double horas_trabalhadas){
        super(nome, ocupacao, salario, id);
        this.horas_trabalhadas = horas_trabalhadas;
    }

    public void cadastrar_funcionario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Estoquista ===");

        System.out.print("Nome: ");
        nome = scanner.nextLine();

        System.out.print("Ocupacao: ");
        ocupacao = scanner.nextLine();

        System.out.print("Salario: ");
        salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("id: ");
        id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        System.out.print("Horas trabalhadas: ");
        horas_trabalhadas = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        Estoquista estoquista = new Estoquista(nome, ocupacao, salario, id, horas_trabalhadas);
        listaEstoquistas.add(estoquista);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public double salario() {
        return this.salario * this.horas_trabalhadas;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nValidade: " + ocupacao +
                "\nSalario: " + salario +
                "\nId: " + id +
                "\nHoras_trabalhadas: " + horas_trabalhadas +
                "\n----------------------";
    }
}