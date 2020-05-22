int batchSize = 0;

for (DataPoint dp : datapoints) {
    stmt.setLong(1, fId);
    stmt.setDate(2, new java.sql.Date(dp.getDate().getTime()));
    stmt.setDouble(3, dp.getValue());
    stmt.setDate(4, new java.sql.Date(modifiedDate.getTime()));
    stmt.addBatch();

    //When limit reach, execute and reset the counter
    if(batchSize++ >= BATCH_LIMIT){
        statement.executeBatch();

        batchSize = 0;
    }
}        

// To execute the remaining items
if(batchSize > 0){
    statement.executeBatch();
}