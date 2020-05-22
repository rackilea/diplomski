try {
Class.forName("driverName");  //driver name
Connection con = DriverManager.getConnection("url", "user", "pass");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("Select * from tablename"); //table you want to get information from
HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet sheet = workbook.createSheet("sheetName"); //name the sheet
HSSFRow rowhead = sheet.createRow((short) 0);
rowhead.createCell((short) 0).setCellValue("CellHeadName1"); //name the cells 
rowhead.createCell((short) 1).setCellValue("CellHeadName2");
rowhead.createCell((short) 2).setCellValue("CellHeadName3");
int i = 1;
while (rs.next()){
    HSSFRow row = sheet.createRow((short) i);
    row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("column1"))); //name columns
    row.createCell((short) 1).setCellValue(rs.getString("column2"));
    row.createCell((short) 2).setCellValue(rs.getString("column3"));
    i++;
}
String xlss= "g:/test.xls";  //the file you want the data put into
FileOutputStream fileOut = new FileOutputStream(xlss);
workbook.write(fileOut);
fileOut.close();
} catch (ClassNotFoundException e1) {
   e1.printStackTrace();
} catch (SQLException e1) {
    e1.printStackTrace();
} catch (FileNotFoundException e1) {
    e1.printStackTrace();
} catch (IOException e1) {
    e1.printStackTrace();
}