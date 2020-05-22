package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;



public class MigLayoutLogin extends JFrame {

    public MigLayoutLogin() {

        initUI();

        setTitle("Log in");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        setLayout(new MigLayout("ins 15"));


        add(new JLabel("User name:"));
        add(new JTextField(10), "pushx, growx, wrap");
        add(new JLabel("Password: "));
        add(new JPasswordField(10), "growx, wrap");

        add(new JButton("Log in"), "span 2, split 2, center, gaptop 15");
        add(new JButton("Log out"));

        pack();
    }    


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutLogin ex = new MigLayoutLogin();
                ex.setVisible(true);
            }
        });
    }        
}