import java.sql.*;

public class UcaNoIde {

    public static void main(String[] args) {
        String dbFileSpec = "C:/Users/Public/UCanAccessTest.accdb";
        String connStr = "jdbc:ucanaccess://" + dbFileSpec;
        try (Connection conn = DriverManager.getConnection(connStr)) {
            System.out.println("Connection established.");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

}