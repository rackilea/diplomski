package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.TRAILING;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GroupLayoutPassword extends JFrame {

    public GroupLayoutPassword() {

        initUI();

        setTitle("Password application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        JLabel serviceLbl = new JLabel("Service:");
        JLabel userNameLbl = new JLabel("User name:");
        JLabel passwordLbl = new JLabel("Password:");

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JTextField field3 = new JTextField(10);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);   

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(TRAILING)
                        .addComponent(serviceLbl)
                        .addComponent(userNameLbl)
                        .addComponent(passwordLbl))
                .addGroup(gl.createParallelGroup()
                        .addComponent(field1)
                        .addComponent(field2)
                        .addComponent(field3))
        );        

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(serviceLbl)
                        .addComponent(field1))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(userNameLbl)
                        .addComponent(field2))
                .addGroup(gl.createParallelGroup(BASELINE)
                        .addComponent(passwordLbl)
                        .addComponent(field3))
        );

        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GroupLayoutPassword ex = new GroupLayoutPassword();
                ex.setVisible(true);
            }
        });
    }
}