public void mergeCells(int startColumn, int startRow, short endColumn, short endRow) {

        if (endRow == 0 && endColumn == 0) {
            return;
        }

        XCell xCell = getCell(column, row); //Custom method to get cell

        XPropertySet props = null;
        try {
            props = (XPropertySet) FileManager.getOOoUnoRuntimeQueryInterface(XPropertySet.class, xCell);
        } catch (Exception ex) {
        // Do error stuff
        }

        XTextTableCursor textTableCursor = null;
        String cellName = null;

        try {
            cellName = props.getPropertyValue("CellName").toString();
        } catch (Exception ex) {
        // Do error stuff
        }

        try {
            textTableCursor = xTextTable.createCursorByCellName(cellName);
            textTableCursor.goRight(endColumn, true);
            textTableCursor.goDown(endRow, true);
            textTableCursor.mergeRange();
        } catch (Exception ex) {
        // Do error stuff
        }

}