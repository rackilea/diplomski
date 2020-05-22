package swingtest;

import java.awt.*;
import javax.swing.*;

public class SwingTest {

    private ImagePanel imagePanel;

    private void displayGUI() {
        JFrame frame = new JFrame("Swing Worker Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        imagePanel = new ImagePanel();      
        contentPane.add(imagePanel);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new SwingTest().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}