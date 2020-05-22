package persistence;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtils
{
    private static final String URL = "jdbc:mysql://localhost:3306/contacts";
    private static final String USERNAME = "contacts";
    private static final String PASSWORD = "contacts";

    public static final String SELECT_SQL = "select customer_id, name, street, city, state, zip, phone, url from customer order by customer_id";
    public static final String INSERT_SQL = "insert into customer(name, street, city, state, zip, phone, url) values(?,?,?,?,?,?,?)";

    public static void main(String[] args)
    {
        Connection connection = null;

        try
        {
            connection = getConnection(URL, USERNAME, PASSWORD);
            List<Map> rows = findAllCustomers(connection);

            for (Map row : rows)
            {
                System.out.println(row);                    
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close(connection);
        }
    }

    public static List<Map> findAllCustomers(Connection connection) throws SQLException
    {
        List<Map> rows = new ArrayList<Map>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try
        {
            st = connection.prepareStatement(SELECT_SQL);
            rs = st.executeQuery();
            while (rs.next())
            {
                rows.add(map(rs));                
            }
        }
        finally
        {
            close(rs);
            close(st);
        }

        return rows;
    }

    private static Map<String, Object> map(ResultSet rs) throws SQLException
    {
        Map<String, Object> row = new LinkedHashMap<String, Object>();

        ResultSetMetaData meta = rs.getMetaData();

        int numColumns = meta.getColumnCount();
        for (int i = 1; i <= numColumns; ++i)
        {
            String column = meta.getColumnName(i);
            Object value = rs.getObject(i);
            row.put(column, value);
        }

        return row;
    }

    public static Connection getConnection(String url, String username, String password) throws SQLException
    {
        Driver driver = DriverManager.getDriver(url);

        DriverManager.registerDriver(driver);

        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void close(Statement st)
    {
        try
        {
            if (st != null)
            {
                st.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs)
    {
        try
        {
            if (rs != null)
            {
                rs.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void rollback(Connection connection)
    {
        try
        {
            if (connection != null)
            {
                connection.rollback();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}