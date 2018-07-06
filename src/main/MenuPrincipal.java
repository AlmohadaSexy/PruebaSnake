package main;

import Toolkit.SettingsManager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MenuPrincipal{
    private JFrame frame;
    private SettingsManager setMan = new SettingsManager();
    public JPanel panelRight;
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
    public MenuPrincipal(int i){

    }
    private void initialize() {
        frame = new JFrame("MenuPrincipal");

        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);
        panel.setLayout(new GridLayout(1,0));

        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new GridLayout(3,0));

        panelRight = new JPanel();
        panelRight.setLayout(new GridLayout(1,0));

        JSplitPane splitVertical = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
        panel.add(splitVertical);

        JButton btn1 = new JButton("Jugar");
        btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClearRightPanel();
                // panelRight.removeAll();
                //frame.dispose();
                //JOptionPane.showMessageDialog(null, "No hay juego xd", "rip", JOptionPane.INFORMATION_MESSAGE);

                panelRight.updateUI();
            }
        });
        panelLeft.add(btn1);



        JButton btn2 = new JButton("Settings");
        btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClearRightPanel();
                SettingsPanel settingsPanel = new SettingsPanel();
                panelRight.add(settingsPanel);
                panelRight.updateUI();
            }
        });
        panelLeft.add(btn2);

        JButton btn3 = new JButton("Salir");
        btn3.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        panelLeft.add(btn3);
    }

    public void ClearRightPanel(){
        panelRight.removeAll();
        panelRight.updateUI();
    }
}