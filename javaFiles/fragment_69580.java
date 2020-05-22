InitialContext ic = new InitialContext();
// that's everything from the context.xml and from the global configuration
Context xmlContext = (Context) ic.lookup("java:comp/env");
DataSource myDatasource = (DataSource) xmlContext.lookup("jdbc/MyDatasource");

// now get a connection to see if everything is fine.
Connection con = ds.getConnection();
// reaching this point means everything is fine.
con.close();