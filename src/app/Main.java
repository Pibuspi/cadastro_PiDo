package app;

import view.TelaBatman;

public class Main {

    public static void main(String[] args) {
        // 1. Define o visual para o padrão do sistema operacional
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Se o Nimbus não estiver disponível, ele usa o padrão
        }

        // 2. Abre a tela
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBatman().setVisible(true);
            }
        });
    }
}
