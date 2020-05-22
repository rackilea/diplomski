@WebServlet(name = "TestUsertServlet", urlPatterns = {"/TestUsertServlet"})
@PersistenceContext(
    unitName = "DataPersistencePU")
@TransactionAttribute(REQUIRED)
 public class TestUsertServlet extends HttpServlet {

@Resource
private javax.transaction.UserTransaction utx;

@PersistenceContext
EntityManager em;

protected void processRequest(HttpServletRequest request,     HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet TestUsertServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet TestUsertServlet at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}

@Override

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try {
        utx.begin();
        TestUser testUser = new TestUser();
        em.persist(testUser);
        utx.commit();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}