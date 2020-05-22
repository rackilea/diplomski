import java.awt.Component;
import java.awt.EventQueue;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class EditorAsRendererTableTest {

    public EditorAsRendererTableTest() {
        JTable table = new JTable(3, 2);
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setCellEditor(new MyCellEditor());
        colModel.getColumn(0).setCellRenderer(new MyCellEditor());
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditorAsRendererTableTest();
            }
        });
    }

    private class MyCellEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

        private static final long serialVersionUID = 1L;
        private JFormattedTextField renderer;
        private JFormattedTextField editor;
        private NumberFormat format = DecimalFormat.getInstance();

        public MyCellEditor() {
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(4);
            format.setRoundingMode(RoundingMode.HALF_UP);
            renderer = new JFormattedTextField(format);
            renderer.setBorder(null);
            editor = new JFormattedTextField(format);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            renderer.setValue(value);
            return renderer;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            editor.setValue(value);
            return editor;
        }

        @Override
        public boolean stopCellEditing() {
            try {
                editor.commitEdit();
            } catch (ParseException e) {
                return false;
            }
            return super.stopCellEditing();
        }

        @Override
        public Object getCellEditorValue() {
            return editor.getValue();
        }
    }
}