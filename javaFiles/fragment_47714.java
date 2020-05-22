Workbook wb = new XSSFWorkbook();
Sheet sheet1 = wb.createSheet("Ripon");
FileOutputStream fileOut = new FileOutputStream("D:\\RiponAlWasim.xlsx");
wb.write(fileOut);
fileOut.close();
wb.close();