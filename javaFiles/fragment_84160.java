import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GridBagLayoutExample {
    private JPanel contentPane;
    private JFrame frame;
    private JLabel label;
    private JTextField field;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridBagLayoutExample().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("GridBagLayout Example");
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        label = new JLabel("A small label");
        field = new JTextField();

        c.insets = new Insets(0, 10, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(label, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth = 2;
        contentPane.add(field, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 20;
        contentPane.add(new JLabel("Another but much larger JLabel"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        c.ipady = 20;
        c.gridwidth = 2;
        contentPane.add(new JButton("And including a larger JButton"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 60;
        contentPane.add(new JLabel("A TALLER ROW!"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        c.ipady = 60;
        c.gridwidth = 2;
        contentPane.add(new JTextField(), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 3;
        c.ipady = 0;
        contentPane.add(new JLabel("Another normal row"), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 2;
        contentPane.add(new JTextField(), c);

        frame.add(contentPane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}