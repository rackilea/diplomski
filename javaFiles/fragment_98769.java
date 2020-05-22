import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HiveJdbcClient {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
//  org.apache.hadoop.hive.jdbc.HiveDriver org.apache.hive.jdbc.HiveDriver
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Before Connecting to hive...");
        try {
            Connection con = DriverManager.getConnection("jdbc:hive2://<Server_name>:10001/test","hive_username","hive_password");
            System.out.println("Connected to hive..");

            // Select query
            Statement stmt = con.createStatement();
            String sql = "select * from test.emp";
            System.out.println("Running: " + sql);
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(String.valueOf(res.getInt(1)) + "\t" + res.getString(2));
            }

            // load data into table
            // NOTE: filepath has to be local to the hive server
            // NOTE: /tmp/a.txt is a ctrl-A separated file with two fields per line
            String tableName = "test.emp";
            String filepath = "D:\\datatoload\\emp1.txt";
            sql = "load data local inpath '" + filepath + "' into table " + tableName;
            System.out.println("Running: " + sql);
            boolean result = stmt.execute(sql);
            if(!result)
                System.out.println("Data load successfully!!!");
            else
                System.out.println("Failed to load data!!!");

            // regular hive query
            sql = "select count(*) from " + tableName;
            System.out.println("Running: " + sql);
            res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getString(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.exit(1);
        }
    }
}