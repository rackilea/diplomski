package yourPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.Test;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class TestDBUnitDummy extends DBTestCase
{

    public TestDBUnitDummy( String name ) throws Exception
    {
        super( name );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:sqlserver://MyServer;databaseName=MyDatabase" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "sa" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "" );
    }

    public static void Export() throws Exception
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:sqlserver://MySourceServer;databaseName=MyDatabase", "sa", "");
        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("TABLE-NAME", "SELECT * FROM [TABLE-NAME]");
        XmlDataSet.write(partialDataSet, new FileOutputStream("table.xml"));
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("table_flat.xml"));
    }

    protected void setUpDatabaseConfig( DatabaseConfig config )
    {
    config.setProperty(DatabaseConfig.PROPERTY_ESCAPE_PATTERN , "[?]");
    }

    protected IDataSet getDataSet() throws Exception
    {
        Export();
        return new XmlDataSet( new FileInputStream( "table.xml" ) );
    }


    @Test
    public void test_001()
    {
        assertEquals( "Dummy test", true, true );       
    }

}