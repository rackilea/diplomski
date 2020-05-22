int num = 0;
try {
    num = Integer.parseInt(s2);
} catch (Exception e) {
    System.out.println('Nope, that was not a number');
    //Do something else?
}
String insertQuery = "UPDATE spareparts SET quantity = cast(cast(quantity as integer)+"+num+" as char(20)) where itemcode = "+s1+";";

try {
    connection = DriverManager.getConnection(...); //add your data
    preparedStatement = connection.prepareStatement(sql)
    preparedStatement.executeUpdate();
} catch (Exception e) {
    //Something broke
}