import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;


public class TestFrame extends JFrame{

    private MyModel model;
    private JTable table;

    public TestFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        pack();
        setVisible(true);
    }

    private void init() {
        table = new JTable(model = new MyModel());

        JButton add = new JButton("add row");
        add.addActionListener(getAddListener());
        JButton remove = new JButton("remove row");
        remove.addActionListener(getRemoveListener());
        JButton addC = new JButton("add column");
        addC.addActionListener(getAddColListener());
        JButton removeC = new JButton("remove column");
        removeC.addActionListener(getRemoveColListener());

        add(new JScrollPane(table));
        JPanel p = new JPanel();
        p.add(add);
        p.add(remove);
        p.add(addC);
        p.add(removeC);
        add(p,BorderLayout.SOUTH);
    }

    private ActionListener getRemoveColListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedColumn = table.getSelectedColumn();
                if(selectedColumn != -1){
                    stopEditing();
                    model.removeColumn(selectedColumn);
                }
            }
        };
    }

    private ActionListener getAddColListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.addColumn();
            }
        };
    }

    private ActionListener getRemoveListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if(selectedRow != -1){
                    stopEditing();
                    model.removeRow(selectedRow);
                }
            }

        };
    }

    private ActionListener getAddListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow();
            }
        };
    }

    private void stopEditing() {
        TableCellEditor cellEditor = table.getCellEditor();
        if(cellEditor != null){
            cellEditor.stopCellEditing();
        }
    }

    public static void main(String... strings) {
        new TestFrame();
    }

    private class RowData{

        private Map<Integer, Object> values = new HashMap<Integer, Object>();

        public Object getValueForCol(int columnIndex) {
            if(values.containsKey(columnIndex)){
                return values.get(columnIndex);
            }
            return "";
        }

        public void setValueForCol(Object aValue, int columnIndex) {
            values.put(columnIndex, aValue);
        }

    }

    private class MyModel extends AbstractTableModel{

        int colIndex=0;
        private List<Integer> cols = new ArrayList<Integer>();
        private List<RowData> rows = new ArrayList<TestFrame.RowData>();

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public String getColumnName(int column) {
            return cols.get(column).toString();
        }

        @Override
        public int getRowCount() {
            return rows.size();
        }

        public void addRow() {
            rows.add(new RowData());
            fireTableRowsInserted(rows.size(), rows.size());
        }


        public void removeRow(int selectedRow) {
            rows.remove(selectedRow);
            fireTableRowsDeleted(selectedRow, selectedRow);
        }

        public void removeColumn(int selectedColumn) {
            cols.remove(table.convertColumnIndexToModel(selectedColumn));
            fireTableStructureChanged();
        }

        public void addColumn() {
            cols.add(++colIndex);
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return cols.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RowData rowData = rows.get(rowIndex);
            return rowData.getValueForCol(cols.get(columnIndex));
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            RowData rowData = rows.get(rowIndex);
            rowData.setValueForCol(aValue,cols.get(columnIndex));
            fireTableCellUpdated(rowIndex, columnIndex);
        }

    }