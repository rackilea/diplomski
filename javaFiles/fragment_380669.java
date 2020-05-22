import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
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

                JTabbedPane tp = new JTabbedPane();
                tp.add("Person", new JPanel());
                tp.add("Work Detail", new TestPane());

                frame.add(tp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextField name;
        private JTextField serial;
        private JTextField id;
        private JTextField email;

        private JComboBox level;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new Insets(2, 2, 2, 2);

            add(new JLabel("Name"), gbc);
            gbc.gridx += 2;
            add(new JLabel("Sr No"), gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("ID"), gbc);
            gbc.gridx += 2;
            add(new JLabel("Email ID"), gbc);

            name = new JTextField(10);
            serial = new JTextField(10);
            id = new JTextField(10);
            email = new JTextField(10);

            level = new JComboBox(new String[]{"Manager", "Eng Lead", "Eng Designer", "Jr Designer"});

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 1;
            gbc.gridy = 0;
            add(name, gbc);
            gbc.gridx += 2;
            add(serial, gbc);
            gbc.gridx = 1;
            gbc.gridy++;
            add(id, gbc);
            gbc.gridx += 2;
            add(email, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(level, gbc);

            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            add(new JButton("Save"), gbc);
        }

    }

}