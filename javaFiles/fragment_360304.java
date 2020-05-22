1:public class Server extends HttpServlet {
2:  public static int requestNo = 0;
3:  public void doGet(HttpServletRequest req, HttpServletResponse resp)
4:  {
5:     requestNo++;
6:     resp.getWriter().println(requestNo);
7:  }
8:}