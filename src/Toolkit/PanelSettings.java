package Toolkit;

import javax.swing.*;
import java.awt.*;

public class PanelSettings {

    private String[] diff = {"EASY", "NORMAL", "HARD"};
    private String[] resolution = {"Fullscreen"};
    JComboBox resCombo, diffCombo;

    public JPanel getPanelSettings(){
        JPanel panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2,0,0,50));

        screenSizeComboFill();
        diffComboFill();

        panelSettings.add(resCombo);
        panelSettings.add(diffCombo);

        return panelSettings;
    }

    private void screenSizeComboFill(){
        resCombo = new JComboBox();
        addObjectsToCombo(resCombo, resolution);
    }

    private void diffComboFill(){
        diffCombo = new JComboBox();
        addObjectsToCombo(diffCombo, diff);
    }

    private void addObjectsToCombo(JComboBox combo, String[] array){
        Object item;
        for (int i = 0; i < array.length; i++) {
            item = array[i];
            combo.addItem(item);
        }
    }
}
