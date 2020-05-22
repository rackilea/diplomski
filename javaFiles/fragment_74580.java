HSSFRow createRow = spreadsheet.createRow(0);
    CellRangeAddress range = new CellRangeAddress(0, 0, 1, 8);
    spreadsheet.addMergedRegion(range);
    HSSFCell createCell = createRow.createCell(1);
    createCell.setCellValue("My header");//ADD Your Custom Header value Here 
    CellUtil.setAlignment(createCell, workbook, CellStyle.ALIGN_CENTER);