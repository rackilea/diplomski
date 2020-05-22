import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Shows a Stage that has two text Fields
 *
 */
@SuppressWarnings("serial")
public class UserInterface extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;

    /**
     * Constructor
     */
    public UserInterface() {
        super("Sum Dialog");

        // Layout
        setLayout(new FlowLayout());

        // 1st JLabel
        label1 = new JLabel("1st Number:");
        add(label1);
        textField1 = new JTextField(15);
        add(textField1);

        // 2 second JLabel
        label2 = new JLabel("2nd Number");
        add(label2);
        textField2 = new JTextField(15);
        add(textField2);

        // 3 third label
        label3 = new JLabel();
        label3.setSize(200, 30);
        add(label3);

        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // calculate the sum when the Button is pressed
                int sum = Integer.parseInt(textField2.getText()) + Integer.parseInt(textField2.getText());
                label3.setText(Integer.toString(sum));
            }
        });
        add(button);

    }

    /**
     * Main method of the application
     * 
     * @param args
     */
    public static void main(String[] args) {
        UserInterface main = new UserInterface();
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
        main.setSize(180, 160);

    }

}