public static void main(String[] args) throws IOException {
    FileInputStream file = new FileInputStream(new File("C:\\Users\\XXXXXXXXXXXXXXXXal\\042012.xls"));
    HSSFWorkbook wb = new HSSFWorkbook(file);
    HSSFSheet sheet = wb.getSheetAt(0);
    Iterator<Row> rowIterator = sheet.iterator();
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      Iterator <Cell> cellIterator = row.cellIterator();
      while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
        System.out.print(cell.getStringCellValue() + "\t\t");
      }
    }
    file.close();
    FileOutputStream out =
      new FileOutputStream(new File("C:\\test.xls"));
    wb.write(out);
    out.close();
  }