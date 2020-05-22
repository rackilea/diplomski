import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Innocentus
 */
public class MultiLineJTable extends JTable{

    public MultiLineJTable(){
        super();
    }

    public MultiLineJTable(Object[][] row, String[] col){
        DefaultTableModel dtm = new DefaultTableModel(row,col);
        this.setModel(dtm);
        addFireEvent();
        this.setDefaultRenderer(Object.class, new MultiLineCellRendererx());
    }

    @Override
    public void setModel(TableModel dataModel) {
        if (dataModel == null) {
            throw new IllegalArgumentException("Cannot set a null TableModel");
        }
        if (this.dataModel != dataModel) {
            TableModel old = this.dataModel;
            if (old != null) {
                old.removeTableModelListener(this);
            }
            this.dataModel = dataModel;
            dataModel.addTableModelListener(this);

            tableChanged(new TableModelEvent(dataModel, TableModelEvent.HEADER_ROW));

            firePropertyChange("model", old, dataModel);

            if (getAutoCreateRowSorter()) {
                setRowSorter(new TableRowSorter<TableModel>(dataModel));
            }
            addFireEvent();
        }  
        try {
            this.setDefaultRenderer(Object.class, new MultiLineCellRendererx());
        } catch (Exception e) {
        }
    }

    public void refreshTable(){
        JTable tbl = this;
        for (int row = 0; row < tbl.getRowCount(); row++){
            int rowHeight = tbl.getRowHeight();

            for (int column = 0; column < tbl.getColumnCount(); column++){
                Component comp = tbl.prepareRenderer(tbl.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            tbl.setRowHeight(row, rowHeight);
        }
    }

    private void addFireEvent(){
        this.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                switch (e.getType()) {
                    case TableModelEvent.DELETE:
                        refreshTable();
                        break;
                    case TableModelEvent.INSERT:
                        refreshTable();
                        break;
                    case TableModelEvent.UPDATE:
                        refreshTable();
                        break;
                }
            }
        });
    }
}
class MultiLineCellRendererx extends JTextArea implements TableCellRenderer {

    public MultiLineCellRendererx() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setSelectionColor(Color.GREEN);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((String)value);
        setSize(table.getColumnModel().getColumn(column).getWidth(),this.getPreferredSize().height);
        setSelectionColor(Color.GREEN);

        if (isSelected){
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        }else{
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        return this;
    }
}