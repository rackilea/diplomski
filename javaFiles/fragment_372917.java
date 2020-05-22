Cursor cur = db.executeQuery("select * from Persons;");
while (cur.next()) {
    Row currentRow = cur.getRow();
    String dataText = currentRow.getString("Date");
    System.out.println(dataText);
}