try
    {
        conn = ds.getConnection();
    }
    catch (SQLException e)
    {
        System.out.println( e.toString());          
    }