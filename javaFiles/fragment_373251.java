test_conn.setAutoCommit(false);
stmt = test_conn.prepareStatement("INSERT INTO ...");

while(RSet.next()){
   for(int i = 1; i <= columnCount; i++){
       stmt.setString(i, RSet.getString(i));
   }
   stmt.addBatch();
}

stmt.executeBatch();
test_conn.commit();