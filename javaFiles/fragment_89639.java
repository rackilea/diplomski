package com.zetcode;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class FormLayoutPassword extends JFrame {

    public FormLayoutPassword() {

        initUI();

        setTitle("Password application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        FormLayout fl = new FormLayout(
            "r:p, $rg, p:g", // columns
            "");  // rows

        DefaultFormBuilder builder = new DefaultFormBuilder(fl);
        builder.border(Borders.DIALOG); 

        JTextField field1 = new JTextField(10);
        JTextField field2 = new JTextField(10);
        JPasswordField field3 = new JPasswordField(10);        

        builder.append("&Service: ", field1);
        builder.nextLine();

        builder.append("&User name: ", field2);
        builder.nextLine();

        builder.append("&Password: ", field3);
        builder.nextLine();

        JPanel pnl = builder.getPanel();
        setContentPane(pnl);

        pack();

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormLayoutPassword ex = new FormLayoutPassword();
                ex.setVisible(true);
            }
        });
    }
}