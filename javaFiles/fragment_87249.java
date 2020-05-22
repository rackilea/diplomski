String excelFilePath = "D:\\Temp.xls";
Test excelWriter = new Test();
List<Book> listBook = excelWriter.getListBook();
try {
    excelWriter.writeExcel(listBook, excelFilePath);
    System.out.println("Excel file written successfully");
} catch (IOException e) {
    e.printStackTrace();
}