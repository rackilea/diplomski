import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PlaceholderRenderer extends DefaultTableCellRenderer {

    final private String placeholder;

    public PlaceholderRenderer(String placeholder) {
        super();
        this.placeholder = placeholder;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        if ((value == null) || (value.equals(""))) { 
            return super.getTableCellRendererComponent(table, this.placeholder, isSelected, hasFocus, row, column);  
        } else { 
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
        }
    }

}