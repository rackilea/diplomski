import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
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

            JButton order1 = new JButton("Order");
            JButton order2 = new JButton("Order");
            JButton order3 = new JButton("Order");
            JButton order4 = new JButton("Order");
            JButton order5 = new JButton("Order");
            JButton order6 = new JButton("Order");
            JButton order7 = new JButton("Order");
            JButton order8 = new JButton("Order");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(8, 8, 8, 8);

            add(order1, gbc);
            gbc.gridx++;
            add(order2, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(order3, gbc);
            gbc.gridx++;
            add(order4, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(order5, gbc);
            gbc.gridx++;
            add(order6, gbc);
            gbc.gridx = 0;
            gbc.gridy++;
            add(order7, gbc);
            gbc.gridx++;
            add(order8, gbc);
        }

    }

}