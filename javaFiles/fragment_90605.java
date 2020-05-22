public class SQLDateTableCellRenderer extends DefauktTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table,
                                           Object value,
                                           boolean isSelected,
                                           boolean hasFocus,
                                           int row,
                                           int column) {
        if (value instanceof java.sql.Date) {
            value = new SimpleDateFormat("dd/MM/yyyy").format(value);
        }

        retrun super.getTableCellRenderer(...);
    }

}