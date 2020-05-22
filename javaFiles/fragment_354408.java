package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * BookDao
 * @author Michael
 * @since 4/6/11
 */
public class BookDao
{
    public static final String SELECT_ALL_BOOKS = "SELECT * FROM Books";

    private Connection connection;

    public BookDao(Connection connection)
    {
        this.connection = connection;
    }

    public List<String> find() throws SQLException
    {
        List<String> isbn= new ArrayList<String>();

        Statement statement = null;
        ResultSet result = null;

        try
        {
            statement = this.connection.createStatement();
            result = statement.executeQuery(SELECT_ALL_BOOKS);
            while (result.next())
            {
                isbn.add(result.getString(1));
            }
        }
        finally
        {
            close(result);
            close(statement);
        }

        return isbn;
    }

    private static void close(ResultSet result)
    {
        try
        {
            if (result != null)
            {
                result.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void close(Statement statement)
    {
        try
        {
            if (statement != null)
            {
                statement.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}