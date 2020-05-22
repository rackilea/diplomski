PreparedStatement ps = null;
ResultSet rs = null;
final int FETCH_LIMIT   = 5; //number of elements to fetch per batch
final int BATCH_LIMIT   = 3; //number of batches you would want

int currentRows = 0;
try{
    ps = connection.prepareStatement("SELECT * FROM table1 LIMIT ?,?");
    for(int currentBatch = 0; currentBatch < BATCH_LIMIT; currentBatch++){
        ps.clearParameters();
        ps.setInt(1, currentRows);
        ps.setInt(2, currentRows + FETCH_LIMIT);

        try{
            rs = ps.executeQuery();
            while(rs.next()){
                // do your work
            }
        }catch(Exception exe){
            //manage exception
        }finally{
            //manage resultset
        }
        currentRows += FETCH_LIMIT;
    }
}catch(Exception exe){
    //Handle your exception
}
finally{
    //Manage your resources
}