import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mercado {
    public static void main(String[] args) {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        ArrayList<Produto> listaProdutos = new ArrayList<>();

        // Lendo o arquivo "comida.csv"
        try {
            BufferedReader reader = new BufferedReader(new FileReader("comida.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String nome = data[0];
                String validade = data[1];
                double preco = Double.parseDouble(data[2]);
                int estoque = Integer.parseInt(data[3]);
                String marca = data[4];
                String categoria = data[5];
                String peso = data[6];

                Comida comida = new Comida(nome, validade, preco, estoque, marca, categoria, peso);
                listaProdutos.add(comida); // Adicionar comida à lista de produtos
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo comida.csv: " + e.getMessage());
        }

        // Lendo o arquivo "bebida.csv"
        try {
            BufferedReader reader = new BufferedReader(new FileReader("bebida.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String nome = data[0];
                String validade = data[1];
                double preco = Double.parseDouble(data[2]);
                int estoque = Integer.parseInt(data[3]);
                String marca = data[4];
                String categoria = data[5];
                String volume = data[6];

                Bebida bebida = new Bebida(nome, validade, preco, estoque, marca, categoria, volume);
                listaProdutos.add(bebida); // Adicionar bebida à lista de produtos
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo bebida.csv: " + e.getMessage());
        }

        // Lendo o arquivo "caixa.csv"
        try {
            BufferedReader reader = new BufferedReader(new FileReader("caixa.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String nome = data[0];
                String ocupacao = data[1];
                double salario = Double.parseDouble(data[2]);
                int id = Integer.parseInt(data[3]);
                double comissao = Double.parseDouble(data[4]);

                Caixa caixa = new Caixa(nome, ocupacao, salario, id, comissao);
                listaFuncionarios.add(caixa);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo caixa.csv: " + e.getMessage());
        }

        // Lendo o arquivo "estoquista.csv"
        try {
            BufferedReader reader = new BufferedReader(new FileReader("estoquista.csv"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String nome = data[0];
                String ocupacao = data[1];
                double salario = Double.parseDouble(data[2]);
                int id = Integer.parseInt(data[3]);
                double horas_trabalhadas = Double.parseDouble(data[4]);

                Estoquista estoquista = new Estoquista(nome, ocupacao, salario, id, horas_trabalhadas);
                listaFuncionarios.add(estoquista);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo estoquista.csv: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Criar venda");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Listar funcionários");
            System.out.println("4 - Cadastrar comida");
            System.out.println("5 - Cadastrar bebida");
            System.out.println("6 - Cadastrar estoquista");
            System.out.println("7 - Cadastrar caixa");
            System.out.println("8 - Gerar salario estoquista");
            System.out.println("9 - Gerar salario caixa");
            System.out.println("0 - Sair");


            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    criarVenda(scanner, listaProdutos, listaFuncionarios);
                    break;
                case 2:
                    for (Produto produto : listaProdutos) {
                        if (produto instanceof Comida) {
                            System.out.println(produto.toString());
                        } else if (produto instanceof Bebida) {
                            System.out.println(produto.toString());
                        }
                    }
                    break;
                case 3:
                    for (Funcionario funcionario : listaFuncionarios) {
                        if (funcionario instanceof Caixa) {
                            System.out.println(funcionario.toString());
                        } else if (funcionario instanceof Estoquista) {
                            System.out.println(funcionario.toString());
                        }
                    }
                    break;
                case 4:
                    Comida comida = new Comida("", "", 0.0, 0, "", "", "");
                    comida.cadastrar_produto();
                    break;
                case 5:
                    Bebida bebida = new Bebida("", "", 0.0, 0, "", "", "");
                    bebida.cadastrar_produto();
                    break;
                case 6:
                    Estoquista estoquista = new Estoquista("","",0.0,0,0.0);
                    estoquista.cadastrar_funcionario();
                    break;
                case 7:
                    Caixa caixa = new Caixa("", "",0.0,0,0.0);
                    caixa.cadastrar_funcionario();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;

                case 8:
                    System.out.print("ID do estoquista: ");
                    int estoquistaId = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada

                    Estoquista estoquistaEncontrado = null;
                    for (Funcionario funcionario : listaFuncionarios) {
                        if (funcionario instanceof Estoquista && funcionario.getId() == estoquistaId) {
                            estoquistaEncontrado = (Estoquista) funcionario;
                            break;
                        }
                    }

                    if (estoquistaEncontrado != null) {
                        double salarioEstoquista = estoquistaEncontrado.salario();
                        System.out.println("Salário do Estoquista: R$" + salarioEstoquista);
                    } else {
                        System.out.println("Estoquista não encontrado.");
                    }
                    break;
                case 9:
                    System.out.print("ID do caixa: ");
                    int caixaId = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada

                    Caixa caixaEncontrado = null;
                    for (Funcionario funcionario : listaFuncionarios) {
                        if (funcionario instanceof Caixa && funcionario.getId() == caixaId) {
                            caixaEncontrado = (Caixa) funcionario;
                            break;
                        }
                    }

                    if (caixaEncontrado != null) {
                        double salarioCaixa = caixaEncontrado.salario();
                        System.out.println("Salário do Caixa: R$" + salarioCaixa);
                    } else {
                        System.out.println("Caixa não encontrado.");
                    }
                    break;
            }
        }
    }

    public static void criarVenda(Scanner scanner, ArrayList<Produto> listaProdutos, ArrayList<Funcionario> listaFuncionarios) {
        ArrayList<Produto> carrinho = new ArrayList<>();

        System.out.println("Adicione produtos ao carrinho (digite 'sair' para finalizar):");
        while (true) {
            System.out.print("Nome do produto: ");
            String nomeProduto = scanner.nextLine();

            if (nomeProduto.equalsIgnoreCase("sair")) {
                break;
            }

            Produto produtoEncontrado = null;
            for (Produto produto : listaProdutos) {
                if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoEncontrado = produto;
                    break;
                }
            }

            if (produtoEncontrado != null) {
                carrinho.add(produtoEncontrado);
                System.out.println("Produto adicionado ao carrinho: " + produtoEncontrado.getNome());
            } else {
                System.out.println("Produto não encontrado.");
            }
        }

        // Solicitar o caixa ao usuário
        Caixa caixaSelecionado = null;
        while (caixaSelecionado == null) {
            System.out.print("ID do caixa: ");
            int caixaId = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            for (Funcionario funcionario : listaFuncionarios) {
                if (funcionario instanceof Caixa && funcionario.getId() == caixaId) {
                    caixaSelecionado = (Caixa) funcionario;
                    break;
                }
            }

            if (caixaSelecionado == null) {
                System.out.println("Caixa não encontrado.");
            }
        }

        // Solicitar o nome do cliente ao usuário
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        // Calcular valor total
        double valorTotal = 0.0;
        for (Produto produto : carrinho) {
            valorTotal += produto.getPreco();
        }

        // Criar venda e gerar nota fiscal
        Venda venda = new Venda("11/06/2023", caixaSelecionado.getNome(), nomeCliente, carrinho, valorTotal);
        venda.criar_venda("16/06/2023", caixaSelecionado.getNome(), nomeCliente, carrinho, valorTotal);



    }

}