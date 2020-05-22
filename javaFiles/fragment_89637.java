package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class MigLayoutPassword extends JFrame {

    public MigLayoutPassword() {

        initUI();

        setTitle("Password application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout("wrap 2, ins dialog", 
                "[right][grow]"));

        JLabel serviceLbl = new JLabel("Service:");
        JLabel userNameLbl = new JLabel("User name:");
        JLabel passwordLbl = new JLabel("Password:");

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JPasswordField field3 = new JPasswordField(10);

        pnl.add(serviceLbl);
        pnl.add(field1, "growx");

        pnl.add(userNameLbl);
        pnl.add(field2, "growx");

        pnl.add(passwordLbl);
        pnl.add(field3, "growx");

        add(pnl);

        pack();

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutPassword ex = new MigLayoutPassword();
                ex.setVisible(true);
            }
        });
    }
}