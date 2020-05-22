JTable table = new JTable(data, columnNames)
{
    public TableCellRenderer getCellRenderer(int row, int column)
    {
        if (column == 0)
        {
            Class cellClass = getValueAt(row, column).getClass();
            return getDefaultRenderer( cellClass );
        }

        return super.getCellRenderer(row, column);
    }

    public boolean isCellEditable(int row, int column)
    {
        Class cellClass = getValueAt(row, column).getClass();

        if (column == 0 && cellClass instanceof Boolean)
        {
            return true;
        }
        else
        {
            return false;
        }

        return super.isCellEditable(row, column);
    }

};