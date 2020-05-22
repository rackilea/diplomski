public class TestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private static final Log log = LogFactory.getLog(TestServlet.class);

  private ApplicationContext ctx;

  public void init() throws ServletException {
    ctx = new ClassPathXmlApplicationContext("beans.xml");
  }

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Wrapper bean = ctx.getBean("wrapperBean", Wrapper.class);
    String value = bean.inner.value;
    resp.getWriter().print(value);
  }
}