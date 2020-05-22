package com.zetcode;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridBagLayoutTriangle extends JFrame {

    public GridBagLayoutTriangle() {

        initUI();

        setTitle("Triangle");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUI() {

        JPanel imgPanel = new JPanel();
        imgPanel.setPreferredSize(new Dimension(150, 150));
        imgPanel.setBorder(BorderFactory.createEtchedBorder());

        final JPanel triPanel = new JPanel(new GridBagLayout());
        triPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.left = 5;
        gbc.insets.top = 5;

        triPanel.add(new JLabel("Height:"), gbc); 

        gbc.gridx = 1;
        triPanel.add(new JTextField(10), gbc); 

        gbc.gridx = 2;
        triPanel.add(new JLabel("Base:"), gbc); 

        gbc.gridx = 3;
        triPanel.add(new JTextField(10), gbc); 

        gbc.gridx = 0;
        gbc.gridy = 1;
        triPanel.add(new JLabel("Side 2:"), gbc); 

        gbc.gridx = 1;
        triPanel.add(new JTextField(10), gbc); 

        gbc.gridx = 2;
        triPanel.add(new JLabel("Side 3:"), gbc); 

        gbc.gridx = 3;
        triPanel.add(new JTextField(10), gbc); 

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.insets.top = 10;
        gbc.fill = GridBagConstraints.CENTER;
        triPanel.add(new JButton("Calculate"), gbc); 

        gbc.gridy = 3;
        gbc.insets.bottom = 10;
        triPanel.add(imgPanel, gbc); 

        add(triPanel);

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GridBagLayoutTriangle ex = new GridBagLayoutTriangle();
                ex.setVisible(true);
            }
        });
    }
}