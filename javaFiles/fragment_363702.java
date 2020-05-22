import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CellHighlighter {

    private static class CellHighlighterRenderer extends JLabel implements TableCellRenderer {

        public CellHighlighterRenderer() {
            setOpaque(true); // Or color won't be displayed!
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String val = (String)value;
            Color c;
            if (val.matches(".*MIN.*")) // Add a method to configure the regexpr
                c = Color.YELLOW; // Add a method to configure color
            else
                c = UIManager.getColor("Table.background");
            setBackground(c);
            setText(val);
            return this;
        }
    }

    public static void main(String[] args) {
        String[] columnNames = {
            "Login", "Real name", "Age", "Birthday"
        };
        String[][] data = {
            {"toto", "Toto Mackwert", "73", "18/06/1940"},
            {"adm", "ADMINISTRATOR", "13", "01/01/2000"},
            {"AMINA", "Amina Farou", "3", "01/01/2010"},
        };
        JTable table = new JTable(data, columnNames);
        table.setDefaultRenderer(Object.class, new CellHighlighterRenderer());
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}