CellStyle cellStyle = wb.createCellStyle();
CreationHelper createHelper = wb.getCreationHelper();
cellStyle.setDataFormat(
    createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
cell = row.createCell(1);
cell.setCellValue(new Date());
cell.setCellStyle(cellStyle);