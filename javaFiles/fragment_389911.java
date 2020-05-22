DatabaseMetaData databaseMetaData = connection.getMetaData();
ResultSet typeInfo = databaseMetaData.getTypeInfo();
System.out.println("type name                      | data type | searchable");
System.out.println("-------------------------------+-----------+------------");
while (typeInfo.next()) {
    String typeName = typeInfo.getString("TYPE_NAME");
    int dataType = typeInfo.getInt("DATA_TYPE");
    boolean searchable = typeInfo.getShort("SEARCHABLE") != DatabaseMetaData.typePredNone;
    System.out.printf("%-30s | %-9d | %-9s%n", typeName , dataType, searchable);
}