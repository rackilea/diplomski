import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ResizeTest {

    public static void main(String[] args) {
        new ResizeTest();
    }

    public ResizeTest() {
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

        private JTable table;
        private JButton historyButton;
        private JButton otherButton;

        public TestPane() {

            table = new JTable(new DefaultTableModel(10, 10));
            historyButton = new JButton("History");
            otherButton = new JButton("Other");

            setLayout(new BorderLayout());
            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
            buttons.add(historyButton);
            buttons.add(otherButton);
            add(buttons, BorderLayout.NORTH);

            add(new JScrollPane(table));

            JPanel footers = new JPanel(new GridLayout(1, 2));
            JLabel left = new JLabel("Left");
            left.setHorizontalAlignment(JLabel.LEFT);
            JLabel right = new JLabel("Right");
            right.setHorizontalAlignment(JLabel.LEFT);
            footers.add(left);
            footers.add(right);

            add(footers, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}