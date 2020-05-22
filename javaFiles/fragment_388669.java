@Override
public Component getTableCellRendererComponent(
    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
{
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    // add custom rendering code

    if (isSelected)
        setBackground( table.getSelectionBackground() );
    else
        setBackground( table.getBackground() );

    return this;
}