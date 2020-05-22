import java.awt.event.*;
import javax.swing.*;

public class TestTextField {

    public static void main(String[] args) {
        final JTextField field = new JTextField(15);
        field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter Pressed: " + field.getText());
            }
        });
        JOptionPane.showMessageDialog(null, field);
    }
}