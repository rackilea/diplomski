package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class DetailsPanel extends JFrame {

    public DetailsPanel() {

        initUI();

        setTitle("Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        setLayout(new MigLayout("ins 10, wrap 2", "[][grow]"));

        add(new JLabel("Label 1:"));
        add(new JTextField(), "w 200, growx");

        add(new JLabel("Label 2:"));
        add(new JTextField(), "growx");    

        add(new JLabel("Label 3:"));
        add(new JTextField(), "gaptop 30, growx");

        add(new JLabel("Label 4:"));
        add(new JTextField(), "growx");      

        add(new JLabel("Label 5:"));
        add(new JTextField(), "gaptop 30, growx");

        add(new JLabel("Label 6:"));
        add(new JTextField(), "growx");          

        add(new JButton("Submit"), "gaptop 30, skip, right");


        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DetailsPanel ex = new DetailsPanel();
                ex.setVisible(true);
            }
        });
    }
}