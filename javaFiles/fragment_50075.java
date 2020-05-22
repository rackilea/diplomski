Statement stmt;
ResultSet rs;
boolean done = false;
int i = 0;
while(!done) {
    try {
        stmt = connections[i].createStatement();
        rs = stmt.executeQuery("select * from aTable");
        rs.beforeFirst();
        while(rs.next()) {
            // Do whatever you need with the result set
        }
        done = true;
    } catch(SQLException e) {
        // Catch the exception and try with the next connection
        i++;
    }
}