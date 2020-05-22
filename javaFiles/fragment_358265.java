import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestGUI {
    public static void main (String[] args) {

        JFrame frame = new JFrame("Test");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel label1 = new JLabel("label1");
        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();
        JLabel label2 = new JLabel("label2");
        JButton button1 = new JButton("Button");

        text1.setColumns(10);
        text2.setColumns(10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(label1, constraints);
        constraints.gridx = 1;
        panel.add(text1, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(label2, constraints);
        constraints.gridx = 1;
        panel.add(text2, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(button1, constraints);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}