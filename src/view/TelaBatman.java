package view;

import javax.swing.*;
import java.awt.*;

public class TelaBatman extends JFrame {
    
    private static final long serialVersionUID = 1L;

    public TelaBatman() {
        // Configurações básicas da janela
        setTitle("Cadastro PiDo - Sistema de Clientes");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Adiciona a TelaCliente (JPanel) como um "adesivo" no centro
        TelaCliente telaCliente = new TelaCliente();
        add(telaCliente, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaBatman().setVisible(true);
        });
    }
}
