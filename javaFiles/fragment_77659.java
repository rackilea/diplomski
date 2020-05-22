public Data getMyData() {
    Connection conn = null;
    Statement statement = null;
    try {
        conn = ConnectionPool.getConnection();
        statement conn.prepareStatement("select mydata from mytable");
        //execute statement, get results
        //return Data
    }finally{
        if (statement != null) statement.close();        
        if (conn != null) conn.close(); //release the connection back to the pool
    }
}