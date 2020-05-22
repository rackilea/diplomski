@BeforeClass
public static void beforeClass() throws Exception {

    Properties properties = new Properties();
    //build your properties to the remove class
    Context context = new InitialContext(properties);
    //look up your dataSource
    DataSource ds = (DataSource) context.lookup("");
    //now build the simple
    SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
    builder.bind("jdbc/dataSource", ds);

}