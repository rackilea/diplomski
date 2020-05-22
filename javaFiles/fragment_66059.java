ResultSet rs = stmt.executeQuery("select * from table1");

int columns = rs.getMetaData().getColumnCount();

StringBuilder message = new StringBuilder();

while (rs.next()) {
    for (int i = 1; i <= columns; i++) {
        message.append(rs.getString(i) + " ");
    }
    message.append("\n");
}

System.out.println(message);  // print table contents