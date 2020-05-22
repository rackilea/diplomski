import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableEdit {

    public static void main(String[] args) {
        new TableEdit();
    }

    public TableEdit() {
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
            setLayout(new BorderLayout());
            JTable table = new JTable(new MyTableModel());
            table.setSurrendersFocusOnKeystroke(true);
            TableColumnModel model = table.getColumnModel();
            model.getColumn(1).setCellRenderer(new MyTableCellRenderer());
            add(new JScrollPane(table));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class MyData {

        private String key;
        private String value;
        private boolean changed;

        public MyData(String key, String value) {
            this.key = key;
            this.value = value;
            this.changed = false;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String newValue) {
            if (value == null ? newValue != null : !value.equals(newValue)) {
                value = newValue;
                changed = true;
            }
        }

        public boolean hasChanged() {
            return changed;
        }
    }

    public class MyTableModel extends AbstractTableModel {

        private List<MyData> data;

        public MyTableModel() {
            data = new ArrayList<>(25);
            for (int index = 0; index < 5; index++) {
                data.add(new MyData("A" + (index + 1), "B" + (index + 1)));
            }
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            MyData myData = data.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = myData.getKey();
                    break;
                case 1:
                    value = myData.getValue();
                    break;
            }
            return value;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 1;
        }

        public boolean hasChanged(int rowIndex) {
            MyData myData = data.get(rowIndex);
            return myData.hasChanged();
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            MyData myData = data.get(rowIndex);
            myData.setValue(aValue == null ? null : aValue.toString());
        }
    }

    public class MyTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setOpaque(isSelected);
            TableModel model = table.getModel();
            if (model instanceof MyTableModel) {
                MyTableModel myModel = (MyTableModel) model;
                if (myModel.hasChanged(row)) {
                    if (!isSelected) {
                        setBackground(Color.RED);
                        setOpaque(true);
                    } 
                }
            }
            return this;
        }
    }
}