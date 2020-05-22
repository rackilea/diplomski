import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.layout.TableColumnLayout;

public class ColumnHelper {
    public static void createColumn(Table table) {
        TableColumnLayout layout = new TableColumnLayout();
        table.getParent().setLayout(layout);
        TableColumn column = new TableColumn (table, SWT.NONE);
        layout.setColumnData(column, new ColumnWeightData(10));
    }
}