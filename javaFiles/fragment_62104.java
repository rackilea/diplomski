...
    boolean areEqual =
            areEqualIgnoreBothNull(catalog, catalogName, caseSensitive) &&
            areEqualIgnoreNull(schema, schemaName, caseSensitive) &&
            areEqualIgnoreNull(table, tableName, caseSensitive) &&
            areEqualIgnoreNull(column, columnName, caseSensitive);

    return areEqual;


    private boolean areEqualIgnoreBothNull(String value1, String value2,
                                       boolean caseSensitive) {
            boolean areEqual = true;
            if (value1 != null && value2 != null) {
                if (value1.equals("") && value2.equals("")) {
                    if (caseSensitive) {
                        areEqual = value1.equals(value2);
                    } else {
                        areEqual = value1.equalsIgnoreCase(value2);
                    }
                }
            }
            return areEqual;
        }