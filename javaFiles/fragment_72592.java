package com.example;

import java.awt.*;
import javax.swing.*;

public class MyJavaMacOSXApp extends JPanel {

    public MyJavaMacOSXApp() {
        JLabel versionLabel = new JLabel("java.version=" + System.getProperty("java.version"));
        JLabel homeLabel = new JLabel("java.home=" + System.getProperty("java.home"));
        setLayout(new BorderLayout());
        add(versionLabel, BorderLayout.PAGE_START);
        add(homeLabel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MyJavaMacOSXApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyJavaMacOSXApp newContentPane = new MyJavaMacOSXApp();
        newContentPane.setOpaque(true); 
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}