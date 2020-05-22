public ResultSet runMutltipleQueries(String [] arrayOfQueries) throws SQLException{
    ResultSet rs = null;
    Statement stmnt= con.createStatement();
    boolean rsReturned=false;
    for(int i=0; i<arrayOfQueries.length;i++){
       rsReturned = stmnt.execute(arrayOfQueries[i]);
    }
    if(rsReturned){
        rs= stmnt.getResultSet();
    }

    return rs;

}