double time = DateUtil.convertTime("19:30:00");
    CellStyle cellStyle = workbook.createCellStyle();
    cellStyle.setDataFormat(
            workbook.createDataFormat().getFormat("HH:MM AM/PM"));
    cell.setCellValue(time);
    cell.setCellStyle(cellStyle);