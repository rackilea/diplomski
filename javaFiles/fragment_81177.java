import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

class ColorTableModel extends AbstractTableModel {

    Object rowData[][] = {{"Name 1", Color.RED}, {"Name 2", Color.BLUE}, {"Name 3", Color.GREEN}};

    String columnNames[] = {"Name", "Color"};

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return rowData.length;
    }

    public Object getValueAt(int row, int column) {
        return rowData[row][column];
    }

    public Class getColumnClass(int column) {
        return this.rowData[0][column].getClass();
    }

    public void setValueAt(Object value, int row, int column) {
        rowData[row][column] = value;
    }

    public boolean isCellEditable(int row, int column) {
        return (column != 0);
    }
}

class ColorChooserEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton button = new JButton();

    Color savedColor;

    public ColorChooserEditor() {
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                Color color = JColorChooser.showDialog(button, "Choose a color", savedColor);
                ColorChooserEditor.this.changeColor(color);
            }
        };
        button.addActionListener(actionListener);
    }

    public Color getCellEditorValue() {
        return savedColor;
    }

    private void changeColor(Color color) {
        if (color != null) {
            savedColor = color;
            button.setBackground(color);
        }
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
            int row, int column) {
        changeColor((Color) value);
        return button;
    }

}

class ChooserTableSample {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableModel model = new ColorTableModel();
        JTable table = new JTable(model);

        TableColumn column = table.getColumnModel().getColumn(1);

        TableCellEditor editor = new ColorChooserEditor();
        column.setCellRenderer(new ButtonRenderer());
        column.setCellEditor(editor);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean isFocus, int row, int col) {
        setBackground((Color) value);

        return this;
    }