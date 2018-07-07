package paneles;

import Toolkit.SettingsManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Toolkit.SpringUtilities;
import frame.MainFrame;
import sun.applet.Main;

import javax.swing.*;


public class MenuPrincipal extends MainFrame {
    public JPanel panelRight, setPan;
    public JSplitPane splitVertical;
    JPanel panel = new JPanel();
    Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
    String[] resoluciones = {(int)resolution.getWidth()+"x"+(int)resolution.getHeight(), "1920x1080", "1280x720", "1024x768", "800x600"};
    String[] difficulties = {"FACIL", "NORMAL", "DIFICIL", "HARDCORE"};
    public JComboBox comboRes, comboDiff;
    private JLabel textDiff, textRes;
    SettingsManager s = new SettingsManager();

    public MenuPrincipal() {
        initialize();
        setDividerLocation();
    }

    private void initialize() {
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
                splitVertical.setDividerLocation(0.7);
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
                try {
                    resizeFrame();
                    setDividerLocation();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                splitVertical.setDividerLocation(1.0);
            }
        });
        panelB.add(botonAplicar);
        panel.add(panelP, BorderLayout.CENTER);
        panel.add(panelB, BorderLayout.SOUTH);
        setPan.add(panel);

        return setPan;
    }

    private void resizeFrame() throws Exception{
        dispose();
        s.resolveResolution();
        setExtendedState(NORMAL);
        new MainFrame(s.getResWidth(), s.getResHeight(), getMenu());
        //revalidate();
        panel.updateUI();
    }

    public JPanel getMenu() {
        return panel;
    }
}