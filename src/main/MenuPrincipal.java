package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MenuPrincipal{

    private JFrame frame;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPrincipal();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuPrincipal() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("MenuPrincipal");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double anchuraPantalla = (screenSize.getWidth())/3;
        double alturaPantalla = (screenSize.getHeight()/2);
        frame.setUndecorated(true);

        frame.setSize((int) anchuraPantalla, (int) alturaPantalla);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 0));
        frame.setContentPane(panel);

        JButton btn1 = new JButton("Jugar");
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
        //        new VentanaSistema().open();
            }
        });
        panel.add(btn1);

        JButton btn2 = new JButton("Elegir dificultad");
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btn2.addActionListener(new ActionListener() {
            @SuppressWarnings("static-access")
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
        //       new VentanaConicas().open();
            }
        });
        panel.add(btn2);

        JButton btn3 = new JButton("Salir");
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        panel.add(btn3);
    }
}