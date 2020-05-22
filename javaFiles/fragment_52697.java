while (true) {
    rs = cstmt.getResultSet();
    int updateCount = cstmt.getUpdateCount();
    LogWriter.write(" Update count " + updateCount);
    if (rs == null && updateCount == -1) {
        break;
    }
    if (rs != null) {
        // process the result set
    } else {
        System.out.println("Update count = " + cstmt.getUpdateCount());
    }
    cstmt.getMoreResults();
}