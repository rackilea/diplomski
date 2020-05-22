import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextAreaExample {

    private static final int GAP = 5;
    private JTextField tField;
    private JTextArea tArea;

    private void displayGUI() {
        JFrame frame = new JFrame("JTextArea Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(GAP, GAP));

        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, GAP, GAP));
        JLabel label = new JLabel("Enter number: ", JLabel.CENTER);
        tField = new JTextField(10);
        tField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int number = Integer.parseInt(tField.getText());
                tArea.setText("");
                for (int i = 1; i <= 10; ++i) {
                    tArea.append("" + number + " X " + i + " = " + (i * number) + "\n");
                }
            }
        });
        upperPanel.add(label);
        upperPanel.add(tField);

        tArea = new JTextArea(10, 10);

        contentPane.add(upperPanel, BorderLayout.PAGE_START);
        contentPane.add(tArea, BorderLayout.CENTER);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTextAreaExample().displayGUI();
            }
        });
    }
}