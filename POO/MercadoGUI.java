import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MercadoGUI extends JFrame implements ActionListener {
    private ArrayList<Funcionario> listaFuncionarios;
    private ArrayList<Produto> listaProdutos;
    private JTextArea outputArea;

    public MercadoGUI() {
        listaFuncionarios = new ArrayList<>();
        listaProdutos = new ArrayList<>();

        // Configurações da janela
        setTitle("Mercado");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Área de saída
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton criarVendaButton = new JButton("Criar Venda");
        criarVendaButton.setActionCommand("criarVenda");
        criarVendaButton.addActionListener(this);
        buttonPanel.add(criarVendaButton);

        JButton listarProdutosButton = new JButton("Listar Produtos");
        listarProdutosButton.setActionCommand("listarProdutos");
        listarProdutosButton.addActionListener(this);
        buttonPanel.add(listarProdutosButton);

        JButton listarFuncionariosButton = new JButton("Listar Funcionários");
        listarFuncionariosButton.setActionCommand("listarFuncionarios");
        listarFuncionariosButton.addActionListener(this);
        buttonPanel.add(listarFuncionariosButton);

        JButton cadastrarComidaButton = new JButton("Cadastrar Comida");
        cadastrarComidaButton.setActionCommand("cadastrarComida");
        cadastrarComidaButton.addActionListener(this);
        buttonPanel.add(cadastrarComidaButton);

        JButton cadastrarBebidaButton = new JButton("Cadastrar Bebida");
        cadastrarBebidaButton.setActionCommand("cadastrarBebida");
        cadastrarBebidaButton.addActionListener(this);
        buttonPanel.add(cadastrarBebidaButton);

        JButton cadastrarEstoquistaButton = new JButton("Cadastrar Estoquista");
        cadastrarEstoquistaButton.setActionCommand("cadastrarEstoquista");
        cadastrarEstoquistaButton.addActionListener(this);
        buttonPanel.add(cadastrarEstoquistaButton);

        JButton cadastrarCaixaButton = new JButton("Cadastrar Caixa");
        cadastrarCaixaButton.setActionCommand("cadastrarCaixa");
        cadastrarCaixaButton.addActionListener(this);
        buttonPanel.add(cadastrarCaixaButton);

        JButton gerarSalarioEstoquistaButton = new JButton("Gerar Salário Estoquista");
        gerarSalarioEstoquistaButton.setActionCommand("gerarSalarioEstoquista");
        gerarSalarioEstoquistaButton.addActionListener(this);
        buttonPanel.add(gerarSalarioEstoquistaButton);

        JButton gerarSalarioCaixaButton = new JButton("Gerar Salário Caixa");
        gerarSalarioCaixaButton.setActionCommand("gerarSalarioCaixa");
        gerarSalarioCaixaButton.addActionListener(this);
        buttonPanel.add(gerarSalarioCaixaButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setActionCommand("sair");
        sairButton.addActionListener(this);
        buttonPanel.add(sairButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Carregar dados dos arquivos
        carregarDados();

        // Exibir janela
        setVisible(true);
    }

    private void carregarDados() {
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
            exibirMensagem("Erro ao ler o arquivo comida.csv: " + e.getMessage());
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
            exibirMensagem("Erro ao ler o arquivo bebida.csv: " + e.getMessage());
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
            exibirMensagem("Erro ao ler o arquivo caixa.csv: " + e.getMessage());
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
            exibirMensagem("Erro ao ler o arquivo estoquista.csv: " + e.getMessage());
        }
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "criarVenda":
                criarVenda();
                break;
            case "listarProdutos":
                listarProdutos();
                break;
            case "listarFuncionarios":
                listarFuncionarios();
                break;
            case "cadastrarComida":
                JFrame cadastroComidaFrame = new JFrame("Cadastrar Comida");
                JPanel cadastroComidaPanel = new JPanel(new GridLayout(7, 2));

                JLabel nomeLabel = new JLabel("Nome:");
                JTextField nomeField = new JTextField();
                cadastroComidaPanel.add(nomeLabel);
                cadastroComidaPanel.add(nomeField);

                JLabel validadeLabel = new JLabel("Validade:");
                JTextField validadeField = new JTextField();
                cadastroComidaPanel.add(validadeLabel);
                cadastroComidaPanel.add(validadeField);

                JLabel precoLabel = new JLabel("Preço:");
                JTextField precoField = new JTextField();
                cadastroComidaPanel.add(precoLabel);
                cadastroComidaPanel.add(precoField);

                JLabel estoqueLabel = new JLabel("Estoque:");
                JTextField estoqueField = new JTextField();
                cadastroComidaPanel.add(estoqueLabel);
                cadastroComidaPanel.add(estoqueField);

                JLabel marcaLabel = new JLabel("Marca:");
                JTextField marcaField = new JTextField();
                cadastroComidaPanel.add(marcaLabel);
                cadastroComidaPanel.add(marcaField);

                JLabel categoriaLabel = new JLabel("Categoria:");
                JTextField categoriaField = new JTextField();
                cadastroComidaPanel.add(categoriaLabel);
                cadastroComidaPanel.add(categoriaField);

                JLabel pesoLabel = new JLabel("Peso:");
                JTextField pesoField = new JTextField();
                cadastroComidaPanel.add(pesoLabel);
                cadastroComidaPanel.add(pesoField);

                int resultado = JOptionPane.showConfirmDialog(cadastroComidaFrame, cadastroComidaPanel, "Cadastrar Comida",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultado == JOptionPane.OK_OPTION) {
                    String nome = nomeField.getText();
                    String validade = validadeField.getText();
                    double preco = Double.parseDouble(precoField.getText());
                    int estoque = Integer.parseInt(estoqueField.getText());
                    String marca = marcaField.getText();
                    String categoria = categoriaField.getText();
                    String peso = pesoField.getText();

                    Comida comida = new Comida(nome, validade, preco, estoque, marca, categoria, peso);
                    listaProdutos.add(comida);

                    exibirMensagem("Comida cadastrada com sucesso!");
                }
                break;

            case "cadastrarBebida":
                JFrame cadastroBebidaFrame = new JFrame("Cadastrar Bebida");
                JPanel cadastroBebidaPanel = new JPanel(new GridLayout(7, 2));

                JLabel nomeBebidaLabel = new JLabel("Nome:");
                JTextField nomeBebidaField = new JTextField();
                cadastroBebidaPanel.add(nomeBebidaLabel);
                cadastroBebidaPanel.add(nomeBebidaField);

                JLabel validadeeLabel = new JLabel("Validade:");
                JTextField validadeeField = new JTextField();
                cadastroBebidaPanel.add(validadeeLabel);
                cadastroBebidaPanel.add(validadeeField);

                JLabel precooLabel = new JLabel("Preço:");
                JTextField precooField = new JTextField();
                cadastroBebidaPanel.add(precooLabel);
                cadastroBebidaPanel.add(precooField);

                JLabel estoqueeLabel = new JLabel("Estoque:");
                JTextField estoqueeField = new JTextField();
                cadastroBebidaPanel.add(estoqueeLabel);
                cadastroBebidaPanel.add(estoqueeField);

                JLabel marcaaLabel = new JLabel("Marca:");
                JTextField marcaaField = new JTextField();
                cadastroBebidaPanel.add(marcaaLabel);
                cadastroBebidaPanel.add(marcaaField);

                JLabel categoriaaLabel = new JLabel("Categoria:");
                JTextField categoriaaField = new JTextField();
                cadastroBebidaPanel.add(categoriaaLabel);
                cadastroBebidaPanel.add(categoriaaField);

                JLabel volumeeLabel = new JLabel("Volume:");
                JTextField volumeeField = new JTextField();
                cadastroBebidaPanel.add(volumeeLabel);
                cadastroBebidaPanel.add(volumeeField);

                int resultadoBebida = JOptionPane.showConfirmDialog(cadastroBebidaFrame, cadastroBebidaPanel, "Cadastrar Bebida",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultadoBebida == JOptionPane.OK_OPTION) {
                    String nomeBebida = nomeBebidaField.getText();
                    String validadeBebida = validadeeField.getText();
                    double precoBebida = Double.parseDouble(precooField.getText());
                    int estoqueBebida = Integer.parseInt(estoqueeField.getText());
                    String marcaBebida = marcaaField.getText();
                    String categoriaBebida = categoriaaField.getText();
                    String volumeBebida = volumeeField.getText();

                    Bebida bebida = new Bebida(nomeBebida, validadeBebida, precoBebida, estoqueBebida, marcaBebida, categoriaBebida, volumeBebida);
                    listaProdutos.add(bebida);

                    exibirMensagem("Bebida cadastrada com sucesso!");
                }
                break;

            case "cadastrarEstoquista":
                JFrame cadastroEstoquistaFrame = new JFrame("Cadastrar Estoquista");
                JPanel cadastroEstoquistaPanel = new JPanel(new GridLayout(5, 2));

                JLabel nomeEstoquistaLabel = new JLabel("Nome:");
                JTextField nomeEstoquistaField = new JTextField();
                cadastroEstoquistaPanel.add(nomeEstoquistaLabel);
                cadastroEstoquistaPanel.add(nomeEstoquistaField);

                JLabel ocupacaoLabel = new JLabel("Ocupação:");
                JTextField ocupacaoField = new JTextField();
                cadastroEstoquistaPanel.add(ocupacaoLabel);
                cadastroEstoquistaPanel.add(ocupacaoField);

                JLabel salarioLabel = new JLabel("Salário:");
                JTextField salarioField = new JTextField();
                cadastroEstoquistaPanel.add(salarioLabel);
                cadastroEstoquistaPanel.add(salarioField);

                JLabel idLabel = new JLabel("ID:");
                JTextField idField = new JTextField();
                cadastroEstoquistaPanel.add(idLabel);
                cadastroEstoquistaPanel.add(idField);

                JLabel horasTrabalhadasLabel = new JLabel("Horas Trabalhadas:");
                JTextField horasTrabalhadasField = new JTextField();
                cadastroEstoquistaPanel.add(horasTrabalhadasLabel);
                cadastroEstoquistaPanel.add(horasTrabalhadasField);

                int resultadoEstoquista = JOptionPane.showConfirmDialog(cadastroEstoquistaFrame, cadastroEstoquistaPanel, "Cadastrar Estoquista",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultadoEstoquista == JOptionPane.OK_OPTION) {
                    String nomeEstoquista = nomeEstoquistaField.getText();
                    String ocupacao = ocupacaoField.getText();
                    double salario = Double.parseDouble(salarioField.getText());
                    int id = Integer.parseInt(idField.getText());
                    double horasTrabalhadas = Double.parseDouble(horasTrabalhadasField.getText());

                    Estoquista estoquista = new Estoquista(nomeEstoquista, ocupacao, salario, id, horasTrabalhadas);
                    listaFuncionarios.add(estoquista);

                    exibirMensagem("Estoquista cadastrado com sucesso!");
                }
                break;

            case "cadastrarCaixa":
                JFrame cadastroCaixaFrame = new JFrame("Cadastrar Caixa");
                JPanel cadastroCaixaPanel = new JPanel(new GridLayout(5, 2));

                JLabel nomeCaixaLabel = new JLabel("Nome:");
                JTextField nomeCaixaField = new JTextField();
                cadastroCaixaPanel.add(nomeCaixaLabel);
                cadastroCaixaPanel.add(nomeCaixaField);

                JLabel ocupacaoLabelCaixa = new JLabel("Ocupação:");
                JTextField ocupacaoFieldCaixa = new JTextField();
                cadastroCaixaPanel.add(ocupacaoLabelCaixa);
                cadastroCaixaPanel.add(ocupacaoFieldCaixa);

                JLabel salarioLabelCaixa = new JLabel("Salário:");
                JTextField salarioFieldCaixa = new JTextField();
                cadastroCaixaPanel.add(salarioLabelCaixa);
                cadastroCaixaPanel.add(salarioFieldCaixa);

                JLabel idLabelCaixa = new JLabel("ID:");
                JTextField idFieldCaixa = new JTextField();
                cadastroCaixaPanel.add(idLabelCaixa);
                cadastroCaixaPanel.add(idFieldCaixa);

                JLabel comissaoLabel = new JLabel("Comissão:");
                JTextField comissaoField = new JTextField();
                cadastroCaixaPanel.add(comissaoLabel);
                cadastroCaixaPanel.add(comissaoField);

                int resultadoCaixa = JOptionPane.showConfirmDialog(cadastroCaixaFrame, cadastroCaixaPanel, "Cadastrar Caixa",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultadoCaixa == JOptionPane.OK_OPTION) {
                    String nomeCaixa = nomeCaixaField.getText();
                    String ocupacaoCaixa = ocupacaoFieldCaixa.getText();
                    double salarioCaixa = Double.parseDouble(salarioFieldCaixa.getText());
                    int idCaixa = Integer.parseInt(idFieldCaixa.getText());
                    double comissao = Double.parseDouble(comissaoField.getText());

                    Caixa caixa = new Caixa(nomeCaixa, ocupacaoCaixa, salarioCaixa, idCaixa, comissao);
                    listaFuncionarios.add(caixa);

                    exibirMensagem("Caixa cadastrado com sucesso!");
                }
                break;
            case "gerarSalarioEstoquista":
                JFrame gerarSalarioFrame = new JFrame("Gerar Salário do Estoquista");
                JPanel gerarSalarioPanel = new JPanel(new GridLayout(2, 2));

                JLabel estoquistaIdLabel = new JLabel("ID do Estoquista:");
                JTextField estoquistaIdField = new JTextField();
                gerarSalarioPanel.add(estoquistaIdLabel);
                gerarSalarioPanel.add(estoquistaIdField);

                int resultadoSalario = JOptionPane.showConfirmDialog(gerarSalarioFrame, gerarSalarioPanel, "Gerar Salário do Estoquista",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultadoSalario == JOptionPane.OK_OPTION) {
                    int estoquistaId = Integer.parseInt(estoquistaIdField.getText());

                    Estoquista estoquistaEncontrado = null;
                    for (Funcionario funcionario : listaFuncionarios) {
                        if (funcionario instanceof Estoquista && funcionario.getId() == estoquistaId) {
                            estoquistaEncontrado = (Estoquista) funcionario;
                            break;
                        }
                    }

                    if (estoquistaEncontrado != null) {
                        double salarioEstoquista = estoquistaEncontrado.salario();
                        exibirMensagem("Salário do Estoquista: R$" + salarioEstoquista);
                    } else {
                        exibirMensagem("Estoquista não encontrado.");
                    }
                }
                break;

            case "gerarSalarioCaixa":
                JFrame gerarSalarioCaixaFrame = new JFrame("Gerar Salário do Caixa");
                JPanel gerarSalarioCaixaPanel = new JPanel(new GridLayout(2, 2));

                JLabel caixaIdLabel = new JLabel("ID do Caixa:");
                JTextField caixaIdField = new JTextField();
                gerarSalarioCaixaPanel.add(caixaIdLabel);
                gerarSalarioCaixaPanel.add(caixaIdField);

                int resultadoSalarioCaixa = JOptionPane.showConfirmDialog(gerarSalarioCaixaFrame, gerarSalarioCaixaPanel, "Gerar Salário do Caixa",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultadoSalarioCaixa == JOptionPane.OK_OPTION) {
                    int caixaId = Integer.parseInt(caixaIdField.getText());

                    Caixa caixaEncontrado = null;
                    for (Funcionario funcionario : listaFuncionarios) {
                        if (funcionario instanceof Caixa && funcionario.getId() == caixaId) {
                            caixaEncontrado = (Caixa) funcionario;
                            break;
                        }
                    }

                    if (caixaEncontrado != null) {
                        double salarioCaixa = caixaEncontrado.salario();
                        exibirMensagem("Salário do Caixa: R$" + salarioCaixa);
                    } else {
                        exibirMensagem("Caixa não encontrado.");
                    }
                }
                break;

            case "sair":
                int confirmacaoSaida = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa?", "Confirmar saída",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (confirmacaoSaida == JOptionPane.YES_OPTION) {
                    exibirMensagem("O programa foi encerrado.");
                    System.exit(0);
                }
                break;

        }
    }


    private void criarVenda() {
        ArrayList<Produto> carrinho = new ArrayList<>();

        while (true) {
            String nomeProduto = JOptionPane.showInputDialog(this, "Nome do produto:");

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
                exibirMensagem("Produto adicionado ao carrinho: " + produtoEncontrado.getNome());
            } else {
                exibirMensagem("Produto não encontrado.");
            }
        }

        // Solicitar o caixa ao usuário
        Caixa caixaSelecionado = null;
        while (caixaSelecionado == null) {
            String caixaIdInput = JOptionPane.showInputDialog(this, "ID do caixa:");
            int caixaId;

            try {
                caixaId = Integer.parseInt(caixaIdInput);
            } catch (NumberFormatException e) {
                exibirMensagem("ID do caixa inválido.");
                continue;
            }

            for (Funcionario funcionario : listaFuncionarios) {
                if (funcionario instanceof Caixa && funcionario.getId() == caixaId) {
                    caixaSelecionado = (Caixa) funcionario;
                    break;
                }
            }

            if (caixaSelecionado == null) {
                exibirMensagem("Caixa não encontrado.");
            }
        }

        String nomeCliente = JOptionPane.showInputDialog(this, "Nome do cliente:");

        double valorTotal = 0.0;
        for (Produto produto : carrinho) {
            valorTotal += produto.getPreco();
        }

        Venda venda = new Venda("16/06/2023", caixaSelecionado.getNome(), nomeCliente, carrinho, valorTotal);
        venda.criar_venda("16/06/2023", caixaSelecionado.getNome(), nomeCliente, carrinho, valorTotal);
    }

    private void listarProdutos() {
        StringBuilder produtosText = new StringBuilder();

        for (Produto produto : listaProdutos) {
            produtosText.append(produto.toString()).append("\n");
        }

        JTextArea produtosTextArea = new JTextArea(produtosText.toString());
        produtosTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(produtosTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Produtos", JOptionPane.PLAIN_MESSAGE);
    }

    private void listarFuncionarios() {
        StringBuilder funcionariosText = new StringBuilder();

        for (Funcionario funcionario : listaFuncionarios) {
            funcionariosText.append(funcionario.toString()).append("\n");
        }

        JTextArea funcionariosTextArea = new JTextArea(funcionariosText.toString());
        funcionariosTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(funcionariosTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Funcionários", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        new MercadoGUI();
    }
}
