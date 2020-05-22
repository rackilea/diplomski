import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Test {

    public static void main(String args[]) {
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

            JPanel topRow = new JPanel(new GridLayout(1, 3));
            topRow.add(new JTextField(10));
            topRow.add(new JButton("Search"));
            topRow.add(new JButton("Clear"));

            JPanel bottomRow = new JPanel(new GridLayout(1, 3));
            bottomRow.add(new JButton("Add"));
            bottomRow.add(new JButton("Detail"));
            bottomRow.add(new JButton("Remove"));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 0;

            add(topRow, gbc);
            gbc.gridy = 2;
            add(bottomRow, gbc);

            gbc.gridy = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(new JList()), gbc);

        }

    }
}