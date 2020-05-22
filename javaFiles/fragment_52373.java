public class Example {
    private final static String JDBC_URL = "jdbc:mysql://localhost/shopdb";
    private final static String JDBC_USERNAME = "username";
    private final static String JDBC_PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = DriverManager.getConnection(JDBC_URL,
                                         JDBC_USERNAME, JDBC_PASSWORD);

        // ...
    }
}