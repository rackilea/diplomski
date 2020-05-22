public void freeDatasource()  {

Connection conn = ds.getConnection;
    try {
        System.out.println("---------"+conn.isClosed());
        conn.close();                             
        System.out.println("-------"+conn.isClosed());

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
         }