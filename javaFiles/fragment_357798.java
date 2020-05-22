Fillo fillo=new Fillo();
Connection connection=fillo.getConnection("C:\\Test.xlsx");
String strQuery="Select * from Sheet1 where ID=100 and name='John'";
Recordset recordset=connection.executeQuery(strQuery);

while(recordset.next()){
    System.out.println(recordset.getField("Details"));
}

recordset.close();
connection.close();