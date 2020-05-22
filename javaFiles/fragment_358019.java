package edu.jtds.main;

import java.sql.*;

public class SqlServerConnTest {

    Connection conn;

    public void connect() {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String dbName = "TestDB";
            String user = "cajeroUpz";
            String password = "cajero";
            //the name of my SQL SERVER 2005 instance
            String SqlServerInstance = "instance=SQL2005";
            String url = "jdbc:jtds:sqlserver://localhost:1433";
            url = url + "/" + dbName;
            url = url + ";" + SqlServerInstance;
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public static void main(String[] args) {
        SqlServerConnTest oSqlServerConnTest = new SqlServerConnTest();
        oSqlServerConnTest.connect();
        String sql = "SELECT * FROM TEST_TABLE";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = oSqlServerConnTest.getConnection(); 
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                System.out.println(String.format("%d %s", 
                    rs.getInt(1), rs.getString(2)));
            }
            rs.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}