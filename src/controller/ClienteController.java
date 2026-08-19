package controller;

import dao.ClienteDAO;
import model.Cliente;
import view.TelaCliente;
import javax.swing.*;

public class ClienteController {

    private TelaCliente tela;
    private ClienteDAO dao;

    public ClienteController(TelaCliente tela) {
        this.tela = tela;
        this.dao = new ClienteDAO();
        initController();
    }

    private void initController() {
        tela.btnInserir.addActionListener(e -> inserirCliente());
        tela.btnAtualizar.addActionListener(e -> atualizarCliente());
    }
    
    public void inserirCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(tela.txtNome.getText());
        cliente.setData_nasc(tela.txtData_nasc.getText());
        cliente.setCpf(tela.txtCpf.getText());
        cliente.setEmail(tela.txtEmail.getText());
        cliente.setSenha(tela.txtSenha.getText());

        try {
            dao.inserir(cliente);
            JOptionPane.showMessageDialog(tela, "Cliente inserido com sucesso!");
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro ao inserir cliente: " + e.getMessage());
        }
    }
    
    public void atualizarCliente() {
        Cliente cliente = new Cliente();
        
        if (!tela.txtId.getText().isEmpty()) {
            cliente.setId(Integer.parseInt(tela.txtId.getText()));
        }

        cliente.setNome(tela.txtNome.getText());
        cliente.setData_nasc(tela.txtData_nasc.getText());
        cliente.setCpf(tela.txtCpf.getText());
        cliente.setEmail(tela.txtEmail.getText());
        cliente.setSenha(tela.txtSenha.getText());

        try {
            dao.atualizar(cliente);
            JOptionPane.showMessageDialog(tela, "Cliente atualizado com sucesso!");
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    private void limparCampos() {
        tela.txtId.setText("");
        tela.txtNome.setText("");
        tela.txtData_nasc.setText("");
        tela.txtCpf.setText("");
        tela.txtEmail.setText("");
        tela.txtSenha.setText("");
    }
}
