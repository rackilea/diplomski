ExcelRead newExcelRead = new ExcelRead();
//newExcelRead.dataReader();
String[][] data = newExcelRead.dataReader();

String host = "smtp.gmail.com";
String port = "587";
for(int i=0;i<data.length;i++){
    String mailTo = data[i][3];
    String mailFrom = data[i][4];
    String password = data[i][5];
    // Send email logic.
}