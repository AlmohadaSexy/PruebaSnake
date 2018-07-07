package frame;

import paneles.MenuPrincipal;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel panel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame(new MenuPrincipal().getMenu());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame() {

    }

    public MainFrame(JPanel panel) {
        this.panel = panel;
        build();
        setVisible(true);
    }

    public void build() {
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        setContentPane(this.panel);
        pack();
        setLocationRelativeTo(null);
    }

}
