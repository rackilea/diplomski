Workbook wb = new XSSFWorkbook();
wb.createSheet();
FileOutputStream fileOut;
try {
     fileOut = new FileOutputStream("workbook.xlsx");
     wb.write(fileOut);
     fileOut.close();
     System.out.println("success");
 } catch (Exception e) {
     throw new RuntimeException("failure", e);
 }