String sql = "ALTER TABLE table_name DROP COLUMN column_name;";
if (sql.matches("(?i:alter\\s+table\\s+.*\\bcolumn\\b.*)")) {
    System.out.println("not allowed");
}
else {
    System.out.println("allowed");
}