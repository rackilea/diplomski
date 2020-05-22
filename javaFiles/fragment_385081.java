package com.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class Test {

    public static void main(String[] args) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            PrintWriter writer = new PrintWriter(file);
            try {
                writer.println("Hello");
                writer.flush();
            } finally {
                writer.close();
            }
            Desktop.getDesktop().open(file);
        }
    }

}