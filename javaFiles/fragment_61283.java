public static String getCreateTableQuery(String tableName) {
    String table = "CREATE TABLE table_name" +
            "(slno INT not NULL AUTO_INCREMENT, " +
            " NAME VARCHAR(100), " +
            " YEAR INT not NULL, " +
            " IMDB INT not NULL)";

    String createTableWithNewNameQuery = table.replaceFirst("table_name'", tableName);
    return createTableWithNewNameQuery;
}