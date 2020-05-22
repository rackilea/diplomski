import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class TestDisabledTextField {

    public static void main(String[] args) {
        UIManager.put("TextField.disabledBackground", Color.YELLOW);

        JTextField textField = new JTextField("Disabled text field", 15);
        textField.setEnabled(false);
        textField.setDisabledTextColor(Color.RED);

        JPanel panel = new JPanel();
        panel.add(textField);

        JOptionPane.showMessageDialog(null, panel);
    }
}