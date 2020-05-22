import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Communicate {

  private static final String dbURL = "jdbc:derby:imagesDB;create=true";
  private static final String tableName = "imageDB";
  private static Connection conn = null;
  private static Statement stmt = null;

  public void insert(String path, String hash, long FileSize,
                     String label_name) throws NoSuchAlgorithmException, Exception {
    try {
      stmt = conn.createStatement();
      stmt.execute("insert into " + tableName + " values (\'" + path
        + "\'," + FileSize + ",\'" + hash + "\'" + ",\'"
        + label_name + "\')");
      stmt.close();
      System.out.println("Inserted into table "+ tableName+ " values (\'" + path
        + "\'," + FileSize + ",\'" + hash + "\'" + ",\'"
        + label_name + "\')");
    } catch (SQLException sqlExcept) {
      sqlExcept.printStackTrace();
    }
  }

  public void loadDriver() {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
      System.out.println("Loaded the appropriate driver");
    } catch (Exception except) {
      except.printStackTrace();
    }
  }

  public void createConnection() {
    try {
      // Get a connection
      conn = DriverManager.getConnection(dbURL);
      System.out.println("Connected to and created database ");
    } catch (Exception except) {
      except.printStackTrace();
    }
  }

  public void createTable() throws SQLException {
    Statement st = conn.createStatement();
    st.execute("CREATE TABLE "
      + tableName
      + " (fullPath VARCHAR(512), fileSize INTEGER, md5 VARCHAR(512), label_name VARCHAR(100))");
    System.out.println("Created table "+ tableName);
  }

  public void indexTable() throws SQLException {
    Statement st = conn.createStatement();
    st.execute("CREATE INDEX imageDBIndex ON imageDB (fullPath, label_name)");
    System.out.println("Created index "+ "imageDBIndex");
  }

  public void deleteTable() throws SQLException {
    Statement st = conn.createStatement();
    st.execute("drop table " + tableName);
    System.out.println("Deleted table "+ tableName);
  }

  public String searchBySizeAndMD(String file_path, long size, String hash)
    throws SQLException {
    StringBuilder sb = new StringBuilder();
    Statement st = conn.createStatement();
    ResultSet rs = st
      .executeQuery("SELECT fullPath, label_name FROM (SELECT * FROM imageDB im WHERE im.fileSize = "
        + size + " ) as A WHERE A.md5 = " + "\'" + hash + "\'");
    while (rs.next()) {
      sb.append("Image: (" + rs.getString("fullPath")
        + ") is at label: (" + rs.getString("label_name") + ")\n");
    }
    return sb.toString();
  }

  public String searchByImageName(String fileName) throws SQLException {
    StringBuilder sb = new StringBuilder();
    Statement st = conn.createStatement();
    ResultSet rs = st
      .executeQuery("SELECT fullPath, label_name FROM imageDB im WHERE im.fullPath like \'%"
        + fileName + "%\'");
    while (rs.next()) {
      File out_path = new File(rs.getString("fullPath"));
      if (!fileName.equals(out_path.getName())) continue;
      sb.append("Image: (" + out_path.getPath()
        + ") is at label: (" + rs.getString("label_name") + ")\n");
    }

    return sb.toString();
  }

  public void deleteLabel(String label) throws SQLException {
    Statement st = conn.createStatement();
    st.execute("DELETE FROM " + tableName + " WHERE label_name = \'" + label + "\'");
  }

  public static void main(String[] args)
  {
    Communicate c = new Communicate();
    c.loadDriver();
    try {
      c.createConnection();
      c.createTable();
      c.indexTable();
      c.insert("/some/path", "12323423", 45656567, "label name");
      String s = c.searchBySizeAndMD("/some/path", 45656567, "12323423");
      System.out.println("Search result: "+ s);
      c.deleteTable();
      conn.commit();
      System.out.println("Committed the transaction");

      //Shutdown embedded database
      try
      {
        // the shutdown=true attribute shuts down Derby
        DriverManager.getConnection("jdbc:derby:;shutdown=true");

      }
      catch (SQLException se)
      {
        if (( (se.getErrorCode() == 50000)
          && ("XJ015".equals(se.getSQLState()) ))) {
          // we got the expected exception
          System.out.println("Derby shut down normally");
        } else {
          System.err.println("Derby did not shut down normally");
          System.err.println("  Message:    " + se.getMessage());
        }
      }

    } catch (Exception e) {
      System.err.println("  Message:    " + e.getMessage());
    } finally {
      // release all open resources to avoid unnecessary memory usage

      //Connection
      try {
        if (conn != null) {
          conn.close();
          conn = null;
        }
      } catch (SQLException e) {
        System.err.println("  Message:    " + e.getMessage());
      }
    }
    System.out.println("Communicate finished");
  }


}