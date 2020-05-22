package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestPostgresAutocommit {

    public static void main(String[] args) throws Exception {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://pgdev/dbxxx","xxx","xxx");
        connection.setAutoCommit(true);
        Connection connection2= DriverManager.getConnection("jdbc:postgresql://pgdev/dbxxx","xxx","xxx");
        connection2.setAutoCommit(true);        
        Statement statement=connection.createStatement();
        for (int i=0; i<10; i++) {
            statement.execute("insert into test_gc(col1,col2) values ("+ i + "," + "'" + i + "')");
        }
        statement.close();
        countElements(connection2);
        statement=connection.createStatement();
        statement.execute("delete from test_gc");
        statement.close();
        statement=connection.createStatement();
        statement.execute("begin");
        statement.close();
        statement=connection.createStatement();
        for (int i=0; i<10; i++) {
            statement.execute("insert into test_gc(col1,col2) values ("+ i + "," + "'" + i + "')");
        }
        connection.rollback();
        countElements(connection2);

    }

    private static void countElements(Connection connection2) throws Exception {
        Statement statement2=connection2.createStatement();
        ResultSet rs=statement2.executeQuery("select count(*) from test_gc");
        rs.next();
        System.out.println("row num in table=" + rs.getInt(1)); 
        rs.close();
        statement2.close();

    }

}