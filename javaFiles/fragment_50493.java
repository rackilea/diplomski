import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Password extends JApplet implements ActionListener {

    Container PW = getContentPane();
    JLabel password = new JLabel("Enter Password(and click OK):");
    JLabel message = new JLabel();
    Font font1 = new Font("Times New Roman", Font.BOLD, 18); 
    JTextField input = new JTextField(7);
    JButton enter = new JButton("OK");

    public void start() {
        PW.add(password);
        password.setFont(font1);
        PW.add(input);
        PW.add(enter);
        PW.add(message);
        PW.setLayout(new FlowLayout());
        enter.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String pass1 = input.getText();
        String passwords[] = {"Rosebud", "Redrum", "Jason", "Surrender",  "Dorothy"};
        for(int i=0;i<passwords.length;i++) {
            if (pass1.equalsIgnoreCase(passwords[i])) {
                message.setText("Access Granted");
                            return;
            }
            else {
                message.setText("Access Denied");

            }
        }
    }
}