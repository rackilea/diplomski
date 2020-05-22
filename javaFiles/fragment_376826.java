import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class TestTable {

    public class CheckboxCellRenderer extends JPanel implements TableCellRenderer {

        private JCheckBox checkBox;

        public CheckboxCellRenderer() {
            super(new FlowLayout(FlowLayout.CENTER, 0, 0));
            setOpaque(false);
            checkBox = new JCheckBox();
            checkBox.setOpaque(false);
            checkBox.setHorizontalAlignment(JCheckBox.CENTER);
            add(checkBox);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Object valueInColumn1 = table.getValueAt(row, 1);
            checkBox.setVisible(valueInColumn1 != null);
            checkBox.setSelected(value instanceof Boolean && (Boolean) value);
            return this;
        }
    }

    private JFrame f;
    private JTable table;

    private class MyObject {
        private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

        private String value;

        private boolean selected;

        public MyObject(String value) {
            this.value = value;
        }

        public PropertyChangeSupport getPropertyChangeSupport() {
            return propertyChangeSupport;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
            propertyChangeSupport.firePropertyChange("value", null, value);
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            if (this.selected != selected) {
                this.selected = selected;
                propertyChangeSupport.firePropertyChange("selected", !selected, selected);
            }
        }

    }

    protected void initUI() {
        List<MyObject> objects = new ArrayList<TestTable.MyObject>();
        for (int i = 0; i < 200; i++) {
            MyObject object = new MyObject(i % 3 == 1 ? null : "Row " + (i + 1));
            objects.add(object);
        }
        table = new JTable(new MyTableModel(objects));
        table.setRowHeight(20);
        table.getColumnModel().getColumn(0).setCellRenderer(new CheckboxCellRenderer());
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(table), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

    }

    public class MyTableModel extends AbstractTableModel implements PropertyChangeListener {

        private List<MyObject> objects;

        public MyTableModel(List<MyObject> objects) {
            super();
            this.objects = objects;
            for (MyObject object : objects) {
                object.getPropertyChangeSupport().addPropertyChangeListener(this);
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getSource() instanceof MyObject) {
                int index = objects.indexOf(evt.getSource());
                fireTableRowsUpdated(index, index);
            }
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return objects.size();
        }

        public MyObject getValueAt(int row) {
            return objects.get(row);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
            case 0:
                return getValueAt(rowIndex).isSelected();
            case 1:
                return getValueAt(rowIndex).getValue();
            }
            return null;
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                getValueAt(rowIndex).setSelected(Boolean.TRUE.equals(value));
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 0 && getValueAt(rowIndex).getValue() != null;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
            case 0:
                return Boolean.class;
            case 1:
                return String.class;
            }
            return Object.class;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
            case 0:
                return "Selected";
            case 1:
                return "Value";
            }
            return null;
        }

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

}