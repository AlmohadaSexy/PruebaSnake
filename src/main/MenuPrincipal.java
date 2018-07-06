package main;

import Toolkit.SettingsManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Toolkit.SpringUtilities;

import javax.swing.*;


public class MenuPrincipal{

    private JFrame frame;
    public JPanel panelRight, setPan;
    public JSplitPane splitVertical;
    String[] resoluciones = {"FullScreen", "1920x1080", "1280x720", "1024x768", "800x600"};
    String[] difficulties = {"FACIL", "NORMAL", "DIFICIL", "HARDCORE"};
    public JComboBox comboRes, comboDiff;
    private JLabel textDiff, textRes;
    SettingsManager s = new SettingsManager();

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
        setDividerLocation();
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

        splitVertical = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
        panel.add(splitVertical);
        splitVertical.setDividerSize(0);

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
                panelRight.add(buildSettingsPanel());
                panelRight.updateUI();
                splitVertical.setDividerLocation(0.8);
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

    private void setDividerLocation() {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                splitVertical.setDividerLocation(1.0);
            }
        });
    }

    private JPanel buildSettingsPanel() {
        setPan = new JPanel();
        setPan.setLayout(new GridLayout(1,1));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel panelP = new JPanel(new SpringLayout());
        JPanel panelB = new JPanel();

        textRes = new JLabel("Resolucion:   ");
        textRes.setFont(new Font("Tahoma", Font.PLAIN, 22));
        panelP.add(textRes);
        comboRes = new JComboBox(resoluciones);
        comboRes.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textRes.setLabelFor(comboRes);
        panelP.add(comboRes);


        textDiff = new JLabel("Dificultad:   ");
        textDiff.setFont(new Font("Tahoma", Font.PLAIN, 22));
        panelP.add(textDiff);
        comboDiff = new JComboBox(difficulties);
        comboDiff.setFont(new Font("Tahoma", Font.PLAIN, 22));
        textDiff.setLabelFor(comboDiff);
        panelP.add(comboDiff);

        SpringUtilities.makeGrid(panelP,2,2,6, 6,10,10);

        JButton botonAplicar = new JButton("Aplicar");
        botonAplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                s.populateFields(comboRes.getSelectedItem(), comboDiff.getSelectedItem());
                splitVertical.setDividerLocation(1.0);
            }
        });
        panelB.add(botonAplicar);
        panel.add(panelP, BorderLayout.CENTER);
        panel.add(panelB, BorderLayout.SOUTH);
        setPan.add(panel);

        return setPan;
    }


}