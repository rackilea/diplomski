while (rsColumns.next( ) )
    column = new HashMap<String, String>();

    String type = rsColumns.getString("TYPE_NAME");
    String nullable1 = rsColumns.getString("NULLABLE");
    String nullable2 = rsColumns.getString("IS_NULLABLE");
    String dataType = rsColumns.getString("DATA_TYPE");
    String columnName = rsColumns.getString("COLUMN_NAME");

    column.put("type", type);
    column.put("nullable", nullable1);
    nullableColumns.put(columnName, column)
}