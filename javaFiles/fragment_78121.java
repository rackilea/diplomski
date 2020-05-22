Database database = null;
if (type == DatabaseType.MySQL) {
    database = new MySQLDatabase();
} else if (type == DatabaseType.Derby) {
    database = new DerbyDatabase();
}