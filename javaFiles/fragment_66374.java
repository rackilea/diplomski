public class MySqlDemo {

public static void main(String [] args) {

        java.sql.Connection conn = null;

        System.out.println("SQL Test");

        try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = java.sql.DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test?user=root&password=");

        }
        catch (Exception e) {
                System.out.println(e);
                System.exit(0);
                }

        System.out.println("Connection established");
}