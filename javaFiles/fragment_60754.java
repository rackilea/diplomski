import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbTest {

  private static Logger logger = Logger.getLogger("dbtest");

  // Connection string for an in-memory Derby database
  private static final String DB_URL = "jdbc:derby:memory:myDB;create=true";

  // Creates the table PERSON
  private static final String TABLE_DEF = 
      "CREATE TABLE PERSON ( "
      + "ID INTEGER NOT NULL PRIMARY KEY, "
      + "NAME VARCHAR(50) NOT NULL,"
      + "BIRTHDATE DATE "
      + ")";

  // SQL query for table PERSON
  private static final String QUERY = "SELECT * FROM PERSON";

  // INSERT statement to create some test data
  private static final String INSERT_DATA = 
      "INSERT INTO PERSON (ID, NAME, BIRTHDATE) VALUES (?, ?, ?)";


  /**
   * Create the table PERSON
   * 
   * @param con
   *          The database connection
   */
  private static void createTable(Connection con) {
    try(Statement stmt = con.createStatement()) {
      stmt.executeUpdate(TABLE_DEF);
      con.commit();
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Database error", e);
    }
  }

  /**
   * Insert two records to table PERSON.
   * 
   * @param con
   *          The database connection
   */
  private static void insertTestData(Connection con) {
    try(PreparedStatement prepStmt = con.prepareStatement(INSERT_DATA)) {
      prepStmt.setInt(1, 4711);
      prepStmt.setString(2, "Peter");
      final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      final java.util.Date date = df.parse("1980-03-20");
      prepStmt.setDate(3, new java.sql.Date(date.getTime()));
      prepStmt.execute();

      prepStmt.clearParameters();
      prepStmt.setInt(1, 4712);
      prepStmt.setString(2, "Mary");
      prepStmt.setDate(3, null);
      prepStmt.execute();

      con.commit();
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Database error", e);
    } catch (ParseException e) {
      logger.log(Level.SEVERE, "Date error", e);
    }
  }

  /**
   * Read all columns of all PERSON records in a generic way.
   * 
   * @param con
   *          The database connection
   */
  private static void genericQuery(Connection con) {
    try (Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY)) 
    {
      // Show some meta data. Most interesting are the column count and the 
      // name and SQL type of each column.
      final ResultSetMetaData metaData = rs.getMetaData();
      final int columnCount = metaData.getColumnCount();
      System.out.println(String.format("Found %d columns.", columnCount));
      for(int col = 1; col <= columnCount; col++) {
        final String colName = metaData.getColumnName(col);
        final String colTypeName = metaData.getColumnTypeName(col);
        System.out.println(String.format("Column %d: Name=%s, Type=%s", 
            col, colName, colTypeName));
      }

      // Now read all records.
      int recNo = 0;
      while(rs.next()) {
        recNo++;
        System.out.println(String.format("Record #%d", recNo));

        // Read the record's columns. Column indices start at 1. 
        for(int col = 1; col <= columnCount; col++) {
          // The value returned by the getObject() method has a type according
          // to the JDBC to Java type mapping table.
          // So for VARCHAR a String is returned, for INTEGER an Integer
          // and for DATE a java.sql.Date object.
          final Object value = rs.getObject(col);
          if(value == null) {
            System.out.println(String.format("Col #%d: Value is NULL", col));
          } else {
            System.out.println(String.format("Col #%d: Value is %s, Java type is %s", 
                col, value.toString(), value.getClass().getName()));
          }
        }
      }
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Database error", e);
    }
  }

  public static void main( String[] args ) {
    try (Connection con = DriverManager.getConnection(DB_URL)) {
      createTable(con);
      insertTestData(con);
      genericQuery(con);
    } catch (SQLException e) {
      logger.log(Level.SEVERE, "Database error", e);
    }
  }
}