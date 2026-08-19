package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import controller.ClienteController;

public class TelaCliente extends JPanel {
    
    private static final long serialVersionUID = 1L;

    // Atributos - Campos de texto
    public JTextField txtId, txtNome, txtData_nasc, txtCpf, txtEmail, txtSenha;
    
    // Atributos - Componentes de interface
    public JButton btnInserir, btnAtualizar;
    public JTable tabelaClientes;
    public DefaultTableModel modeloTabela;
    private ClienteController controller;

    public TelaCliente() {
        setLayout(new BorderLayout(10, 10));

        // --- 1. CONSTRUÇÃO DO FORMULÁRIO (PAINEL NORTE) ---
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new BoxLayout(painelFormulario, BoxLayout.Y_AXIS));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));

        // Linha 1: ID, Nome
        JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtId = new JTextField(5); txtId.setEditable(false);
        txtNome = new JTextField(30);
        linha1.add(new JLabel("ID:")); linha1.add(txtId);
        linha1.add(new JLabel("Nome:")); linha1.add(txtNome);

        // Linha 2: Data Nasc e CPF
        JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtData_nasc = new JTextField(10);
        txtCpf = new JTextField(14);
        linha2.add(new JLabel("Data Nasc:")); linha2.add(txtData_nasc);
        linha2.add(new JLabel("CPF:")); linha2.add(txtCpf);

        // Linha 3: Email e Senha
        JPanel linha3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtEmail = new JTextField(20);
        txtSenha = new JTextField(15);
        linha3.add(new JLabel("Email:")); linha3.add(txtEmail);
        linha3.add(new JLabel("Senha:")); linha3.add(txtSenha);

        painelFormulario.add(linha1);
        painelFormulario.add(linha2);
        painelFormulario.add(linha3);

        // --- 2. CONSTRUÇÃO DA TABELA E BOTÕES (PAINEL CENTRAL) ---
        JPanel painelCentral = new JPanel(new BorderLayout());
        
        // Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnInserir = new JButton("Inserir");
        btnAtualizar = new JButton("Atualizar");
        painelBotoes.add(btnInserir);
        painelBotoes.add(btnAtualizar);

        // Configuração da Tabela
        String[] colunas = {"ID", "Nome", "Data Nasc", "CPF", "Email"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaClientes = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaClientes);

        painelCentral.add(painelBotoes, BorderLayout.NORTH);
        painelCentral.add(scrollTabela, BorderLayout.CENTER);

        // Adiciona os painéis principais ao painel
        add(painelFormulario, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);

        // Inicializa o controller e registra os eventos
        this.controller = new ClienteController(this);
    } 
}
