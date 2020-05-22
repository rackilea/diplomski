if (insertList == null) {
} else {
  StringBuilder sb = new StringBuilder();
  sb.append("INSERT INTO ").append(tblname);
  sb.append(" (");

  for (int i = 0; i < columns.length; i++) {
    if (i != 0) {
      sb.append(", ");
    }
    sb.append(columns[i]);
  }
  for (Object[] columnValues : insertList) {
   StringBuilder valueSB = new StringBuilder();
   for (int i = 0; i < columnValues.length; i++) {
      if (i != 0) {
        valueSB.append(", ");
      }
      System.out.println(columnValues[i]);
      valueSB.append("'").append(columnValues[i]).append("'");
    }

    try {
      String sql = sb.toString()
          + "VALUES (" +  valueSB.toString() + ")";
      postgresStmt.executeUpdate(sql);
    } catch (PSQLException e) {
      System.out.println("Duplicate!");
      continue;
    }
  }