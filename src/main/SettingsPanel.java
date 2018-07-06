package main;

import Toolkit.SettingsManager;
import Toolkit.SpringUtilities;


import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {
    String[] resoluciones = {"FullScreen", "1920x1080", "1280x720", "1024x768", "800x600"};
    String[] difficulties = {"FACIL", "NORMAL", "DIFICIL", "HARDCORE"};
    public JComboBox comboRes, comboDiff;
    private JLabel textRes, textDiff;

    public SettingsPanel() {
        JPanel panel = new JPanel(new SpringLayout());

        textRes = new JLabel("Resolucion:   ");
        textRes.setFont(new Font("Tahoma", Font.PLAIN, 22));
        panel.add(textRes);
        comboRes = new JComboBox(resoluciones);
        textRes.setLabelFor(comboRes);
        panel.add(comboRes);


        textDiff = new JLabel("Dificultad:   ");
        textDiff.setFont(new Font("Tahoma", Font.PLAIN, 22));
        panel.add(textDiff);
        comboDiff = new JComboBox(difficulties);
        textDiff.setLabelFor(comboDiff);
        panel.add(comboDiff);

        SpringUtilities.makeCompactGrid(panel,2,2,6, 6,10,10);

        JButton botonAceptar = new JButton();
        botonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(botonAceptar);

        this.add(panel);
    }
}