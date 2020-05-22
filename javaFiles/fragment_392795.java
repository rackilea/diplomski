finally
{
    try
    {
        statement.close();
        con.close();
        sqlite.close();
    }