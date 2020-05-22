public class JScrollTableRenderer extends DefaultTableCellRenderer {

JScrollPane pane = new JScrollPane();

public JScrollTableRenderer()
{
    super();
}

public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column)
{
    pane = (JScrollPane) value;
    return pane;
}
}