PreparedStatement stmt = ...;
boolean isResultSet = stmt.execute();

int count = 0;
while(true) {
    if(isResultSet) {
        rs = stmt.getResultSet();
        while(rs.next()) {
            processEachRow(rs);
        }

        rs.close();
    } else {
        if(stmt.getUpdateCount() == -1) {
            break;
        }

        log.info("Result {} is just a count: {}", count, stmt.getUpdateCount());
    }

    count ++;
    isResultSet = stmt.getMoreResults();
}