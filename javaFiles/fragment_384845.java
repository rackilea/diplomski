public void getSelectedCells()
    {
        if (getColumnSelectionAllowed() && ! getRowSelectionAllowed())
        {
            // Column selection is enabled
            // Get the indices of the selected columns
            int[] vColIndices = getSelectedColumns();
        }
        else if (!getColumnSelectionAllowed() && getRowSelectionAllowed())
        {
            // Row selection is enabled
            // Get the indices of the selected rows
            int[] rowIndices = getSelectedRows();
        }
        else if (getCellSelectionEnabled())
        {
            // Individual cell selection is enabled

            // In SINGLE_SELECTION mode, the selected cell can be retrieved using
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            int rowIndex = getSelectedRow();
            int colIndex = getSelectedColumn();

            // In the other modes, the set of selected cells can be retrieved using
            setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

            // Get the min and max ranges of selected cells
            int rowIndexStart = getSelectedRow();
            int rowIndexEnd = getSelectionModel().getMaxSelectionIndex();
            int colIndexStart = getSelectedColumn();
            int colIndexEnd = getColumnModel().getSelectionModel().getMaxSelectionIndex();

            // Check each cell in the range
            for (int r = rowIndexStart; r < = rowIndexEnd; r++)
            {
                for (int c = colIndexStart; c < = colIndexEnd; c++)
                {
                    if (isCellSelected(r, c))
                    {
                        // cell is selected
                    }
                }
            }
        }
    }