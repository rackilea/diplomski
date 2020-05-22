package org.name.table;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @see https://stackoverflow.com/a/34616583/230513
 */
public class TablePreference {

    private void display() {
        JFrame f = new JFrame("TablePreference");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(new JTable(new PrefModel()) {

            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(128, 32);
            }
        }));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private static class PrefModel extends DefaultTableModel {

        private static final int DEFAULT = 42;
        private static final String VALUE_NAME = "value";
        private final Preferences p = Preferences.userNodeForPackage(TablePreference.class);

        public PrefModel() {
            addColumn("A");
            addRow(new Object[]{p.getInt(VALUE_NAME, DEFAULT)});
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            super.setValueAt(aValue, row, col);
            p.putInt(VALUE_NAME, (int) aValue);
        }

        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TablePreference()::display);
    }
}