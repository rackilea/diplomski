class SpecialTable extends JTable
{
    SpecialTable(Object[][] data, String[] columnNames)
    {
        super(data, columnNames);
// That's already the default        
//        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    /**
     * Called by javax.swing.plaf.basic.BasicTableUI.Handler.adjustSelection(MouseEvent)
     * like: table.changeSelection(pressedRow, pressedCol, e.isControlDown(), e.isShiftDown());
     */
    @Override
    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend)
    {
        if (toggle && !isRowSelected(rowIndex))
            return; // Don't do the selection
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
    }
}