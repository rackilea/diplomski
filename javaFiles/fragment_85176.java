try (java.sql.Connection con = createConnection())
{
    con.setAutoCommit(false);
    try (Statement stm = con.createStatement())
    {
        stm.execute(someQuery); // causes SQLException
    }
    catch(SQLException ex)
    {
        con.rollback();
        con.setAutoCommit(true);
        throw ex;
    }
    con.commit();
    con.setAutoCommit(true);
}