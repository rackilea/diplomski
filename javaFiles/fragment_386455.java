getReadableDatabase().rawQuery(
        String.format("SELECT lis.%s from %s lis LEFT JOIN %s li ON lis.%s = li.%s WHERE li.%s is NULL AND lis.%s LIKE ?;",
            ListItemSuggestion.COLUMN_NAME,
            ListItemSuggestion.TABLE_NAME,
            ListItem.TABLE_NAME,
            ListItemSuggestion.COLUMN_NAME,
            ListItem.COLUMN_NAME,
            ListItem.COLUMN_NAME,
            ListItemSuggestion.COLUMN_NAME
        ),
        new String[]{ "%" + filter + "%" }
    );