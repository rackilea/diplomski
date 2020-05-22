// Do this only once per file
CellStyle cellStyle = wb.createCellStyle();
cellStyle.setDataFormat(
    wb.getCreationHelper().createDataFormat().getFormat("#.#"));

// Create the cell
Cell c = row.createCell(2);
c.setCellValue(8.1);
c.setCellStyle(cellStyle);