package Toolkit;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SettingsManager {

    File settingsFile = new File("settings.txt");
    private String[] settings = new String[2];

    public SettingsManager() {
        createFile();
    }

    private void createFile() {
        if(!settingsFile.exists()){

            try {
                settingsFile.createNewFile();
                populateFields();
                write();
            } catch (Exception e) {
                System.out.println("No se puede crear el archivo");
            }
        } else {
            System.out.println("Archivo ya existe");

        }

    }

    private void populateFields() {
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        settings[0] = "Resolution '" + resolution.getWidth() + "x" + resolution.getHeight() + "'";
        settings[1] = "Diff 'NORMAL'";
    }

    private void write() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(settingsFile, false));
            for (int i = 0; i < settings.length; i++) {
                writer.println(settings[i]);
            }
            writer.close();
        } catch (Exception e){
            System.out.println("No se puede escribir al archivo");
        }
    }

}
