public static void main(String[] args) {
    try {

      write_Excel("myFile.xls","sheetName",
          Arrays.asList("value 1", "value 2", "value 3"));

      write_Excel("myFile.xls","sheetName",
          Arrays.asList("value 4", "value 5", "value 6"));

    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  private static int newRowIndex = 0;
  private static HSSFWorkbook workbook = new HSSFWorkbook();

  public static void write_Excel(String fileName, String sheetName, List<String> dataToWrite) throws IOException {
    FileOutputStream fos = new FileOutputStream(fileName);

    // open or create sheet
    HSSFSheet sheet = workbook.getSheet(sheetName) != null ?
        workbook.getSheet(sheetName) :
        workbook.createSheet(sheetName);

    // create a new row
    HSSFRow row = sheet.createRow(newRowIndex ++);

    // write your data in the new row
    for (int colIndex = 0; colIndex < dataToWrite.size(); colIndex++) {
      HSSFCell cell = row.createCell(colIndex);
      cell.setCellValue(new HSSFRichTextString(dataToWrite.get(colIndex)));
    }

    workbook.write(fos);
    fos.flush();
    fos.close();
  }