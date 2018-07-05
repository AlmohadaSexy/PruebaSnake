package main;

import Toolkit.SettingsManager;

import javax.swing.*;

public class SettingsPanel {

    private JFrame frame;
    private SettingsManager setMan = new SettingsManager();

    public SettingsPanel() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
}
}
