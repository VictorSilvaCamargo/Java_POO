import java.util.ArrayList;
import java.util.Scanner;

public class Caixa extends Funcionario implements Salario {
    private Double comissao;
    private static ArrayList<Caixa> listaCaixas = new ArrayList<>();

    public Caixa(String nome, String ocupacao, Double salario, int id, Double comissao){
        super(nome, ocupacao, salario, id);
        this.comissao = comissao;
    }

    public void cadastrar_funcionario(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Caixa ===");

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

        System.out.print("Comissao: ");
        comissao = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        Caixa caixa = new Caixa(nome, ocupacao, salario, id, comissao);
        listaCaixas.add(caixa);

        System.out.println("Funcionario cadastrado com sucesso!");
    }

    public double salario() {
        return this.salario + this.comissao;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nValidade: " + ocupacao +
                "\nSalario: " + salario +
                "\nId: " + id +
                "\nComissão: " + comissao +
                "\n----------------------";
    }
}