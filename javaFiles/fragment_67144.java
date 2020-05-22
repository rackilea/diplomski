CellStyle orangeStyle = wb.createCellStyle(r.getPhyscal);     
orangeStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
orangeStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

CellStyle redStyle = wb.createCellStyle(r.getPhyscal);
redStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
redStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

..