package main;

import Toolkit.SettingsManager;
import Toolkit.SpringUtilities;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SettingsPanel extends JPanel {
    String[] resoluciones = {"FullScreen", "1920x1080", "1280x720", "1024x768", "800x600"};
    String[] difficulties = {"FACIL", "NORMAL", "DIFICIL", "HARDCORE"};
    public JComboBox comboRes, comboDiff;
    private JLabel textDiff, textRes;
    MenuPrincipal m = new MenuPrincipal(1);

    SettingsPanel() {
        super(new GridLayout(1,1));

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
                new MenuPrincipal().splitVertical.setDividerLocation(1.0);
            }
        });
        panelB.add(botonAplicar);
        panel.add(panelP, BorderLayout.CENTER);
        panel.add(panelB, BorderLayout.SOUTH);
        add(panel);
    }
}