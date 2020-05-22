import java.awt.event.*;
import javax.swing.*;

class CustomPanel extends JPanel
{
    JLabel lab;
    JTextField txtField;

    public CustomPanel() {

        lab = new JLabel("Some Text: ");
        txtField = new JTextField(20);

        add(lab);
        add(txtField);

    }

    public String getText()
    {
       return txtField.getText();
    }

}

public class JOptionPaneDemo {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CustomPanel inputPane = new CustomPanel();
               int value = JOptionPane.showConfirmDialog(null, inputPane, "Demo" ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
               if(value == JOptionPane.OK_OPTION)
               {
                   JOptionPane.showMessageDialog(null, "Value Entered: "+inputPane.getText(), "Demo", JOptionPane.INFORMATION_MESSAGE);
               }

            }
        });
    }
}