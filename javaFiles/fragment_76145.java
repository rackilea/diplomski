workbook.getSheetAt(0).setSelected(false);
workbook.setActiveSheet(1);

...

workbook.setSheetVisibility(workbook.getSheetIndex(sheet),SheetVisibility.HIDDEN);