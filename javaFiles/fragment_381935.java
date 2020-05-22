private final String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

try {
    Class.forName(dbDriver).newInstance(); // use java reflection to load the database driver
} catch (Exception ex) {
    System.out.println("failure");
}