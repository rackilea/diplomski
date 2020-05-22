package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test27 implements Runnable {

    JPanel mainPanel = new JPanel(new GridLayout(1, 1, 5, 5));
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JPanel buttonPanel = new JPanel();
    JButton next = new JButton();

    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("Test");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.yellow);

        panel1.add(label1);
        panel2.add(label2);

        next.setText("Next");
        next.addActionListener(new RandomNumber());

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        buttonPanel.add(next);

        frame.add(mainPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        randomNumber();

        frame.pack();
        frame.setVisible(true);
    }

    public void randomNumber() {
        int randomNumber1 = 0;
        int randomNumber2 = 0;
        randomNumber1 = 1 + (int) (Math.random() * 9);
        randomNumber2 = 1 + (int) (Math.random() * 9);

        label1.setText(String.valueOf(randomNumber1));
        label2.setText(String.valueOf(randomNumber2));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Test27());
    }

    public class RandomNumber implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            randomNumber();
        }

    }
}