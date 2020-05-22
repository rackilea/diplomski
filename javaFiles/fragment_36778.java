long value = resultSet.getLong(colName);
if (resultSet.wasNull()) {
   return null;
} else {
   return Long.valueOf(value);
}