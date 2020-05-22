public class DatabaseAccess extends HttpServlet{
 // JDBC driver name and database URL
      private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      private static final String DB_URL="jdbc:mysql://localhost/dvdsite";
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {