import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FireButtonOnEnter extends JFrame {
    private static final long serialVersionUID = -7346953935931623335L;

    public FireButtonOnEnter() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Print Hello");
        button.addActionListener(e -> System.out.println("Hello world."));
        textField.addActionListener(e -> button.doClick());
        getContentPane().add(textField);
        getContentPane().add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FireButtonOnEnter().setVisible(true));
    }
}