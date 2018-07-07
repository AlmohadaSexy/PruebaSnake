package frame;

import paneles.MenuPrincipal;
import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public JFrame frame;
    private JPanel panel;
    MenuPrincipal m = new MenuPrincipal();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainFrame(){
        initialBuild();
        frame.pack();
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        m.setDividerLocation();
    }

    public MainFrame(int width, int height, JPanel panel) {
        this.panel = panel;
        rebuild();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



    public void initialBuild(){
        frame = new JFrame();
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.setContentPane(m.getMenu());
    }

    public void rebuild() {
        frame = new JFrame();
        frame.setUndecorated(true);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        frame.setContentPane(panel);
    }

}
