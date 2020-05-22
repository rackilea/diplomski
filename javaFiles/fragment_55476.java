import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

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

                String[] columnNames = {"People", "Place", "Organisation", "Event", "Mentions"};

                String[][] rowData = new String[][]{
                    {"Lee", "Hsien Yang", "", "", ""}
                };

                DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);

                tableModel.addColumn(""); // What ever name you want to give it...

                Boolean isFirstLine = true;

                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    tableModel.setValueAt("Hello", row, tableModel.getColumnCount() - 1);
                }

                JTable table = new JTable(tableModel);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}