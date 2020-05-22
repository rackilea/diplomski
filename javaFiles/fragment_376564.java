public XSSFRow createRow(int rownum) {
    CTRow ctRow;
    XSSFRow prev = _rows.get(rownum);
    if(prev != null){
        // the Cells in an existing row are invalidated on-purpose, in order to clean up correctly, we
        // need to call the remove, so things like ArrayFormulas and CalculationChain updates are done 
        // correctly. 
        // We remove the cell this way as the internal cell-list is changed by the remove call and 
        // thus would cause ConcurrentModificationException otherwise
        while(prev.getFirstCellNum() != -1) {
            prev.removeCell(prev.getCell(prev.getFirstCellNum()));
        }

        ctRow = prev.getCTRow();
        ctRow.set(CTRow.Factory.newInstance());
    }
    ...
}