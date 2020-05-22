import java.io.File;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

public class Test {

  public static void main(String[] args) throws Exception {

    File dbDir = new File("/tmp/identity_test"); 
    String connectionTemplate = "jdbc:hsqldb:file:%s/test";
    String connStr = String.format(connectionTemplate, dbDir);
    Connection connection = DriverManager.getConnection(connStr, "", "");
    Statement s = connection.createStatement();
    s.execute("CREATE TABLE test (id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, s VARCHAR(10))");
    PreparedStatement psInsert = connection.prepareStatement("INSERT INTO test (s) VALUES (?)");
    for (int i = 0; i < 3; i++) {
      psInsert.setString(1, "hello");
      psInsert.executeUpdate();
      PreparedStatement psIdentity = connection.prepareStatement("CALL IDENTITY()");
      ResultSet result = psIdentity.executeQuery();
      result.next();
      int identity = result.getInt(1);
      result.close();
      System.out.println(identity);
    }
    connection.close();
  }
}