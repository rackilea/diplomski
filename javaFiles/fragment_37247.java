import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TableWithOthers {

    public TableWithOthers() {

        Object[][] data
                = {{"Hello", "World"},
                {"Hello", "World"},
                {"Hello", "World"},
                {"Hello", "World"}};
        String[] cols = {"Hello", "World"};

        JTable table = new JTable(data, cols);
        JTextField jtf = new JTextField(20);
        JLabel label = new JLabel("This is a text field");
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(jtf);

        JFrame frame = new JFrame();
        frame.add(panel, BorderLayout.SOUTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableWithOthers();
            }
        });
    }
}