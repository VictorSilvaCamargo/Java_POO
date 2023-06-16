public abstract class Funcionario {
    protected String nome;
    protected String ocupacao;
    protected Double salario;
    protected int id;

    public Funcionario(String nome, String ocupacao, Double salario, int id){
        this.nome = nome;
        this.ocupacao = ocupacao;
        this.salario = salario;
        this.id = id;
    }

    public abstract void cadastrar_funcionario();

    public String getNome(){
        return nome;
    }
    public int getId(){
        return id;
    }
}
