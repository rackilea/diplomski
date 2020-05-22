@Resource(lookup = "jdbc/MyDataSource")
DataSource myDataSource;

...

Connection con = myDataSource.getConnection();