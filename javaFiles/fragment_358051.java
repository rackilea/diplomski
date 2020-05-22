ResultSetMetaData rsmd = rs.getMetaData();
int columnsNumber = rsmd.getColumnCount();

while (rs.next()) {
    for(int i = 1; i < columnsNumber; i++)
        System.out.print(rs.getString(i) + " ");
    System.out.println();
}