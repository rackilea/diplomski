import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            JButton helpButton = new JButton("?");
            JTextField projectDirectory = new JTextField(20);
            JTextField documentDirectory = new JTextField(20);
            JButton projectButton = new JButton("Project");
            JButton documentButton = new JButton("Document");
            JButton continueButton = new JButton("Continue to files");

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;

            add(new JLabel("Project Directory"), gbc);
            gbc.gridy++;
            add(new JLabel("Documentation Directory"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            add(projectDirectory, gbc);
            gbc.gridy++;
            add(documentDirectory, gbc);

            gbc.gridx = 2;
            gbc.gridy = 0;
            add(helpButton, gbc);
            gbc.gridy++;
            add(projectButton, gbc);
            gbc.gridy++;
            add(documentButton, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(continueButton, gbc);
        }

    }

}