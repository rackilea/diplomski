import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

public static void main(String[] argv) throws SQLException {

    //-------------------------------------------------------------------------
    System.out.println("-------- MySQL JDBC Connection Testing ------------");

    try {

        Class.forName("com.mysql.jdbc.Driver");

    } catch (ClassNotFoundException e) {

        System.out.println("Where is your MySQL JDBC Driver?");
        e.printStackTrace();
        return;

    }

    System.out.println("MySQL JDBC Driver Registered!");
    Connection connection = null;

    try {
        connection = DriverManager
                .getConnection("jdbc:mysql://192.168.1.8:3306/[DATABASE_NAME_HERE]",
                        "[YOUR_USERNAME]", "[YOUR_PASSWORD]");

    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        return;
    }

    if (connection != null) {
        System.out.println("You made it, take control your database now!");
    } else {
        System.out.println("Failed to make connection!");
    }
    //-------------------------------------------------------------------------

            /*
    Statement stmt = connection.createStatement();
    boolean result = stmt.execute("CREATE TABLE Students " +
            " (student_ID INT UNSIGNED NOT NULL AUTO_INCREMENT, " +
            " PRIMARY KEY (student_ID), firstName varchar(255), " +
            " lastName varchar(255))");
    System.out.println("\tTable creation result: " + result + "\t");
    System.out.println("**Note: The expected result is FALSE");
            */
}
}