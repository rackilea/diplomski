String getCreateTableSql(int columns) {
  StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS itemset (");
  for (int i = 0; i < columns; i++) {
    if (i > 0) {
      sql.append(", ");
    }
    sql.append("item").append(i + 1).append(" TINYINT(10)");
  }
  sql.append(")");
  return sql.toString();
}