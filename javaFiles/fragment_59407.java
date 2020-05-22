@Component(provide=Servlet.class, properties='alias=/path')
 public void MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest rq, HttpServletResponse rsp) {
        ...
    }
 }