public static void main(String[] args) {
    Path inputFile, outFile;
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    cpds.setJdbcUrl("jdbc:mysql://localhost/db?autoReconnect=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
    cpds.setUser(user);
    cpds.setPassword(pass);
    cpds.setInitialPoolSize(5);
    cpds.setMinPoolSize(5);
    cpds.setAcquireIncrement(5);
    cpds.setMaxPoolSize(20);
    List<String> IDList = readList(inputFile);
    try {
        Connection conn;
        conn = cpds.getConnection();
        PreparedStatement stmt = conn.prepareStatement("Select * from table_bla where Nr = ?;");
        PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outFile));
        for(int i = 0; i < IDList.size(); i++) {
            try {
                stmt.setString(1, IDList.get(i));
                findConsequences(stmt, pw);
            } catch (IOException | SQLException e) {
                System.out.println("Error while executing query (find consequences for ID " + IDList.get(i) + ")");
                e.printStackTrace();                    
                System.out.println(e.getMessage());
                return;
            }
        }
        pw.close();
        stmt.close();
        conn.close();
    }
    catch(IOException | SQLException e) {
        System.out.println("Error while writing to file");
        System.out.println(e.getMessage());
        return;
    }
}
private static void findConsequences(PreparedStatement stmt, PrintWriter pw) throws IOException, SQLException{
    List<Result> resultList = new ArrayList<>();
    ResultSet rs;
    ResultSetMetaData rsmd;
    rs = stmt.executeQuery();
    rsmd = rs.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    String[] tmpArray = new String[columnsNumber];
    while (rs.next()) {
        for (int i = 1; i <= columnsNumber; i++) {
            tmpArray[i-1] = rs.getString(i) == null ? "" : rs.getString(i);
        }
        resultList.add(new Result(tmpArray));
    }
    rs.close();
    //Analyze ....
    pw.println("Update table_bla set ..."); 
}