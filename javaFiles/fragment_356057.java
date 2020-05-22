private Map<String, Object> getARow() {
  if (resultSet == null)
    return null;

  Map<String, Object> result = new HashMap<>();
  for (String colName : colNames) {
    try {
      if (!convertType) {
      Object value = resultSet.getObject(colName); // <-- here the exception takes of
      if (value instanceof BigDecimal || value instanceof BigInteger) {
        result.put(colName, value.toString());
      } else {
        result.put(colName, value);
      }
      continue;
    }
// more code there, but left out