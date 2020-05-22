Statement stmt = connection.createStatement() {
try {
    ResultSet rset = stmt.executeQuery(url)
    try {
        while (rset.next()) { 
            System.out.println (rset.getString(1)); 
        }
    } finally {
        rset.close();
    }
} finally {
    stmt.close();
}