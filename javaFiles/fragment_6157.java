if (workbook instanceof XSSFWorkbook) {
   workbook.write(new FileOutputStream("pathToExcelFile.xlsx"));
  } else if (workbook instanceof HSSFWorkbook) {
   workbook.write(new FileOutputStream("pathToExcelFile.xls"));
  }
  workbook.close();