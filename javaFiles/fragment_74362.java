package org.apache.openoffice.sidebar;

import javax.swing.*;

public class SomeClass {
    public SomeClass() {
        ImageIcon icon = new ImageIcon(
              SomeClass.class.getResource("/images/sidebar-icon-48.png"));
        JLabel label = new JLabel(icon);

        JFrame frame = new JFrame("Test");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new SomeClass();
            }
        });
    }
}