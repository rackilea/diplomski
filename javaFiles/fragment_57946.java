package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Buttoner implements ActionListener {
    // JFrame
    private JFrame frame = new JFrame("Button Game");

    // Make JPanels
    private JPanel panelLabel = new JPanel();
    private JPanel buttonGrid = new JPanel(new GridLayout(0, 10));
    private JPanel bottomPanel = new JPanel();

    // JLabel
    private JLabel label1 = new JLabel("The Button Game");

    private JTextArea jta;

    public Buttoner() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createMainPanel());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Change label color
        label1.setForeground(Color.RED);
        // add Label
        panelLabel.add(label1);
        panel.add(panelLabel, BorderLayout.NORTH);

        // add Buttons
        for (int i = 1; i <= 60; i++) {
            String val = Integer.toString(i);
            JButton button = new JButton(val);
            button.addActionListener(this);
            buttonGrid.add(button);
        }
        panel.add(buttonGrid, BorderLayout.CENTER);

        // Add JText Area to bottom JPanel
        String num = "value";
        jta = new JTextArea(num, 1, 1);
        jta.setEditable(false);
        bottomPanel.add(jta);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String args[]) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new Buttoner();
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public void actionPerformed(ActionEvent a) {
        JButton button = (JButton) a.getSource();
        jta.setText(button.getText());
    }
}