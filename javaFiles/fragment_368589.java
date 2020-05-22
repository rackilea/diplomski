public final class DataBaseHandler {

  public static final class DataSources {
    public static final DataSource DB1;
    public static final DataSource DB2;
    public static final DataSource DB3;
    public static final DataSource DB4;

    static {
      try {
        Context ctx = new InitialContext();
        Context envCtx = (Context) ctx.lookup("java:comp/env");
        DB1 = (DataSource) envCtx.lookup("jdbc/DB1");
        DB2 = (DataSource) envCtx.lookup("jdbc/DB2");
        DB3 = (DataSource) envCtx.lookup("jdbc/DB3");
        DB4 = (DataSource) envCtx.lookup("jdbc/DB4");
      } 
      catch (NamingException ex) {
        throw new ExceptionInInitializerError("DataSource is not initialized");
      }
    }
  }
}