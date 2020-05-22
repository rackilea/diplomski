boolean result = stmt.execute(...);
while(true) {
    if (result) {
        ResultSet rs = stmt.getResultSet();
        // Do something with resultset ...
    } else {
        int updateCount = stmt.getUpdateCount();
        if (updateCount == -1) {
            // no more results
            break;
        }
        // Do something with update count ...
    }
    result = stmt.getMoreResults();
}