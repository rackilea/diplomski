try (ResultSet tables = meta.getTables(null, null, "%", new String[] { "TABLE" })) {
    while (tables.next()) {
        String catalog = tables.getString("TABLE_CAT");
        String schema = tables.getString("TABLE_SCHEM");
        String tableName = tables.getString("TABLE_NAME");
        System.out.println("Table: " + tableName);
        try (ResultSet primaryKeys = meta.getPrimaryKeys(catalog, schema, tableName)) {
            while (primaryKeys.next() {
                System.out.println("Primary key: " + primaryKeys.getString("COLUMN_NAME"));
            }
        }
        // similar for exportedKeys
    }
}