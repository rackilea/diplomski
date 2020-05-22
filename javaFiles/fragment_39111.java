preparedStatement = conn.prepareStatement("update table1 set column1='value' where input=?");
while (i.hasNext()) {
    XSSFRow row = (XSSFRow) i.next();
    input = row.getCell(0).toString();

    preparedStatement.clearParameters();
    preparedStatement.setString(1, input);
    result = preparedStatement.executeUpdate();
}

if (preparedStatement != null) {
    preparedStatement.close();
}