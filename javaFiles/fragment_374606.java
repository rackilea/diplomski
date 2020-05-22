@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static Logger logger = Logger.getLogger(HelloServlet.class);

  public HelloServlet() {
    super();
    logger.debug("HelloServlet created");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    logger.debug("get start");
    try { Thread.sleep(5000); }
    catch (InterruptedException e) { e.printStackTrace(); }
    logger.debug("get finish");
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    logger.debug("post start");
    try { Thread.sleep(5000); }
    catch (InterruptedException e) { e.printStackTrace(); }
    logger.debug("post finish");
    super.doPost(req, resp);
  }

}