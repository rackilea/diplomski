import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class JTableCreatingDemo extends JFrame {

    public void createAndShowGUI() {

        Object columnNames[] = { "String-Column", "Number-Column", "Date-Column", "Boolean-Column" };

        Object rowData[][] = { { "some text", 89, LocalDate.now(), new Boolean(true) },
                { "other text", 546, LocalDate.now(), new Boolean(false) } };

        JTable table = new JTable(rowData, columnNames) {

            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setSize(350, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) throws IllegalAccessException {

        EventQueue.invokeLater(() -> new JTableCreatingDemo().createAndShowGUI());
    }
}