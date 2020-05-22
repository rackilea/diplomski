@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Test() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //here you should be able to call this method
      Resource r = new Resource();
      r.getConfigFiles();  


     }

}