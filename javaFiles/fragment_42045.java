int column = ...  // first column is 1 !!
ResultSet rset = ...

ResultSetMetaData metadata = rset.getMetaData();
int precision = metadata.getPrecision(column);
int scale = metadata.getScale(column);