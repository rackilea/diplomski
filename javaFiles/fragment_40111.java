CreationHelper creationHelper = hssfWorkbook.getCreationHelper();
    cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat(("dd.MM.yyyy")));
    HSSFCell c1 = hssfRow.createCell(0);
    HSSFCellUtil.setCellStyleProperty(c1, hssfWorkbook, CellUtil.DATA_FORMAT,
            HSSFDataFormat.getBuiltinFormat(("dd.MM.yyyy")));
    c1.setCellStyle(cellStyle);
    c1.setCellValue(HSSFDateUtil.getExcelDate(new java.util.Date()));