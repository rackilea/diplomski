import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            // First line
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JButton("Clear"), gbc);

            gbc.gridwidth = 1;
            gbc.gridx = 3;
            add(new JButton("/"), gbc);

            // Second line
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(new JButton("7"), gbc);
            gbc.gridx++;
            add(new JButton("8"), gbc);
            gbc.gridx++;
            add(new JButton("9"), gbc);
            gbc.gridx++;
            add(new JButton("+"), gbc);

            // Third line
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(new JButton("4"), gbc);
            gbc.gridx++;
            add(new JButton("5"), gbc);
            gbc.gridx++;
            add(new JButton("6"), gbc);
            gbc.gridx++;
            add(new JButton("-"), gbc);

            // Second line
            gbc.gridx = 0;
            gbc.gridy = 3;
            add(new JButton("1"), gbc);
            gbc.gridx++;
            add(new JButton("2"), gbc);
            gbc.gridx++;
            add(new JButton("3"), gbc);
            gbc.gridx++;
            add(new JButton("*"), gbc);

            // Last line
            gbc.gridx = 0;
            gbc.gridy = 4;
            add(new JButton("0"), gbc);
            gbc.gridx++;
            gbc.gridwidth = 2;
            add(new JButton("="), gbc);
            gbc.gridx += 2;
            gbc.gridwidth = 1;
            add(new JButton("."), gbc);
        }

    }

}