import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ColumnResizer {

    public static void setColumnPreferredWidth(JTable table, int column,
            int preferredWidth) {
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn tableColumn = columnModel.getColumn(column);
        tableColumn.setPreferredWidth(preferredWidth);
    }

}