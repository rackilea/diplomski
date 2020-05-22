import java.sql.*;

public class DerbyProject {
    public static void main(String[] args) throws Exception {
        /* ------- Start DB ----------- */
        final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver).newInstance();

        final String protocol = "jdbc:derby:";
        final String dbName = "derbyDB";
        Connection connection = DriverManager.getConnection(
                protocol + dbName + ";create=true");
        System.out.println("=====    Started/Connected DB    =====");

        /*
         *    Drop table for testing. If we don't drop, running the
         *    same program will fail, if we start our application over
         *    as the new table has been persisted
         */
        final String dropSql = "drop table users";
        Statement statement = connection.createStatement();
        try {
            statement.execute(dropSql);
            System.out.println("=====    Dropped Table 'users'   =====");
        } catch (SQLException e) {
            if (!e.getSQLState().equals("42Y55")) {
                throw e;
            }
        }

        /* ----- Creeate 'users' table  ----- */
        final String createSql = "create table users ( id int, name varchar(32) )";
        statement.execute(createSql);
        System.out.println("=====    Created Table 'users'   =====");

        /* ----- Insert 'peeskillet' into 'users' ----*/
        final String insertSql = "insert into users values ( 1 , 'peeskillet' )";
        statement.execute(insertSql);
        System.out.println("=====    inserted 'peeskillet into 'users'   =====");

        /* ----- Select from 'users' table  ----- */
        final String selectSql = "select name from users where id = 1";
        ResultSet rs = statement.executeQuery(selectSql);
        if (rs.next()) {
            System.out.println("=====    Selected from 'users' with id 1 \n"
                    + "\t\t\t result: " + rs.getString("name") + "  =====");
        }

        /*  ------ Shut Down DB ------- */
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException se) {
            if (((se.getErrorCode() == 50000)
                    && ("XJ015".equals(se.getSQLState())))) {
                System.out.println("Derby shut down normally");
            } else {
                System.err.println("Derby did not shut down normally");
                throw se;
            }
        }

        statement.close();
        rs.close();
        connection.close();
    }
}