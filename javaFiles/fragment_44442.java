import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TableExample {

    public static void main(String[] args) {
        new TableExample();
    }

    public TableExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                int columnCount = 10;
                String[] cols = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    cols[i - 1] = Integer.toString(i);
                }
                DefaultTableModel model = new DefaultTableModel(cols, 0);
                JTable table = new JTable(model);

                table.setCellSelectionEnabled(true);
                table.setColumnSelectionAllowed(true);
                table.setFillsViewportHeight(true);
                table.setSurrendersFocusOnKeystroke(true);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}