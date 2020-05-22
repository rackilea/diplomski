FileOutputStream out = null;
  if (workbook instanceof XSSFWorkbook) out = new FileOutputStream("pathToExcelFile.xlsx");
  else if (workbook instanceof HSSFWorkbook) out = new FileOutputStream("pathToExcelFile.xls");
  if (out != null) {
   workbook.write(out);
   out.close();
  }
  workbook.close();