public static void main(String args[]) throws SQLException, NamingException {

    Context ctx = null;
    try {
        Properties prop = new Properties();
        prop.setProperty(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.fscontext.RefFSContextFactory");
        prop.setProperty(Context.PROVIDER_URL, "file:/C:/JNDI");
        ctx = new InitialContext(prop);

        OracleDataSource ds = new OracleDataSource();
        ds.setDriverType("thin");
        ds.setServerName("123.123.123.123");
        ds.setPortNumber(1521);
        ds.setDatabaseName("xe");
        ds.setUser("username");
        ds.setPassword("password");
        ctx.bind("jdbc/DataSource", ds);

    } catch (NamingException ne) {
        System.err.println(ne.getMessage());

        ne.printStackTrace();
    }

}