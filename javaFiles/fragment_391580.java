import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Interface {
    private JPanel panel;
    private JPanel buttonPane;
    private JLabel label;
    private JLabel label2;
    private JTextField textfield;
    private JTextField textfield2;
    private JTextField textfield3;
    private JTextField textfield4;
    private JTextField textfield5;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    public static void main(String[] args) {
        new Interface();
    }

    public Interface() {
        JFrame frame = new JFrame("Vormen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);

        panel = new JPanel(new FlowLayout());
        buttonPane = new JPanel();
        button = new JButton("cirkel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use absolute path here:
                JLabel label = new JLabel(new ImageIcon("/home/tyrion/circle.png"));
                panel.add(label);
                panel.revalidate();
                panel.repaint();

            }
        });

        buttonPane.add(button);
        // buttonPane.add(button2);
        // buttonPane.add(button3);

        frame.add(buttonPane, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}