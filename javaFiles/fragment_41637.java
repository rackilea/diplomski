import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
            JButton continueButton = new JButton("Continue to files");

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(helpButton, gbc);

            gbc.gridy++;
            add(new FolderSelectionPane("Project Folder"), gbc);
            gbc.gridy++;
            add(new FolderSelectionPane("Documentation Folder"), gbc);
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridy++;
            add(continueButton, gbc);
        }

    }

    public class FolderSelectionPane extends JPanel {

        public FolderSelectionPane(String label) {
            JTextField projectDirectory = new JTextField(20);
            JButton projectButton = new JButton("Folder");

            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 2, 0, 2);
            add(new JLabel(label), gbc);

            gbc.gridx++;
            add(projectDirectory, gbc);

            gbc.gridx++;
            add(projectButton, gbc);
        }

    }

}