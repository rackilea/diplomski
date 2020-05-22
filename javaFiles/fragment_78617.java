package com.zetcode;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class MigLayoutTriangle extends JFrame {

    public MigLayoutTriangle() {

        initUI();

        setTitle("MigLayout triangle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        JPanel imgPanel = new JPanel();
        imgPanel.setPreferredSize(new Dimension(150, 150));
        imgPanel.setBorder(BorderFactory.createEtchedBorder());        

        JPanel pnl = new JPanel(new MigLayout("wrap 5", "[right][][right]"));

        pnl.add(new JLabel("Height:"));
        pnl.add(new JTextField(10));
        pnl.add(new JLabel("Base:"));
        pnl.add(new JTextField(10), "wrap");

        pnl.add(new JLabel("Side 2:"));
        pnl.add(new JTextField(10));
        pnl.add(new JLabel("Side 3:"));
        pnl.add(new JTextField(10), "wrap");      

        pnl.add(new JButton("Calculate"), "spanx, center");
        pnl.add(imgPanel, "spanx, center");

        add(pnl);

        pack();
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutTriangle ex = new MigLayoutTriangle();
                ex.setVisible(true);
            }
        });
    }
}