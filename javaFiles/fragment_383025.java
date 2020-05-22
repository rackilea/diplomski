public class MyServlet extends HttpServlet {

  @Resource
  DataSource ds;

  public void processRequest() {
    try(Connection con = ds.getConnection()) {
      // ...
    }
  }

}