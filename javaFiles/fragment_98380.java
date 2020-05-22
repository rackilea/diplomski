//avoiding all the particular exceptions just for code simplicity purposes...
//in real world applications, you must handle each of these exceptions
public Connection getConnection() throws Exception {
    ctx = new InitialContext();
    ds1 = (javax.sql.DataSource) ctx.lookup(strDSName1);
    return ds1.getConnection();
}