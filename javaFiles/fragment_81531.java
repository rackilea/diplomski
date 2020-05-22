package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyConnectionPool {
    //this pool will hold the connection 
    static List<MyConnection> connectionPool = new ArrayList<>();

    public MyConnectionPool() {
        String mysqlConfigString = "jdbc:mysql://IP:3306/dbname?user=username&password=password";
        int size = 0;
        while (size++ < 10) {
            Connection conn;
            try {
                conn = DriverManager.getConnection(mysqlConfigString);
                MyConnection myConnection = new MyConnection();
                myConnection.setConnection(conn);
                myConnection.setUsed(false);
                connectionPool.add(myConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public MyConnection getConnection(){
        for (MyConnection myConnection : connectionPool) {
            if(myConnection.isUsed()){
                System.out.println("connection is used");
                continue;
            }
            myConnection.setUsed(true);
            return myConnection;
        }
        return null;
    }

}