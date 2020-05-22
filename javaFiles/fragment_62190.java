private void addTableCellMarkup(Cell cell, int pageIndex, PDStructureElement currentRow) {
    COSDictionary cellAttr = new COSDictionary();
    cellAttr.setName(COSName.O, "Table");
    if (cell.getCellMarkup().isHeader()) {
        currentElem = addContentToParent(null, StandardStructureTypes.TH, pages.get(pageIndex), currentRow);
        currentElem.getCOSObject().setString(COSName.ID, cell.getCellMarkup().getId());
        if (cell.getCellMarkup().getScope().length() > 0) {
            cellAttr.setName(COSName.getPDFName("Scope"), cell.getCellMarkup().getScope());
        }
        if (cell.getCellMarkup().getColspan() > 1) {
            cellAttr.setInt(COSName.getPDFName("ColSpan"), cell.getCellMarkup().getColspan());
        }
        if (cell.getCellMarkup().getRowSpan() > 1) {
            cellAttr.setInt(COSName.getPDFName("RowSpan"), cell.getCellMarkup().getRowSpan());
        }
    } else {
        currentElem = addContentToParent(null, StandardStructureTypes.TD, pages.get(pageIndex), currentRow);
    }
    if (cell.getCellMarkup().getHeaders().length > 0) {
        COSArray headerA = new COSArray();
        for (String s : cell.getCellMarkup().getHeaders()) {
            headerA.add(new COSString(s));
        }
        cellAttr.setItem(COSName.getPDFName("Headers"), headerA);
    }
    currentElem.getCOSObject().setItem(COSName.A, cellAttr);
}