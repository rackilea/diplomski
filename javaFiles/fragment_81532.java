package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlTest {

    public static void main(String[] args) throws SQLException {
        MyConnectionPool pool = new MyConnectionPool();

        // connection one
        MyConnection myConnection = pool.getConnection();
        Connection conn = myConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select count(*) as co from asset");
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("co"));
        ps.close();

        // connection tow
        myConnection = pool.getConnection();
        conn = myConnection.getConnection();
        ps = conn.prepareStatement("select count(*) as co from asset");
        rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("co"));

        // connection three
        myConnection = pool.getConnection();
        conn = myConnection.getConnection();
        ps = conn.prepareStatement("select count(*) as co from asset");
        rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("co"));
        //reset connection use status
        myConnection.setUsed(false);

        // re-use connection three
        myConnection = pool.getConnection();
        conn = myConnection.getConnection();
        ps = conn.prepareStatement("select count(*) as co from asset");
        rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getString("co"));
    }

}