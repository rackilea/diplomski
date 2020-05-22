@WebServlet(name = "checkerServlet", urlPatterns = { "/backEnd" })
public class CheckerServlet extends HttpServlet {
    private YourClass yourClass;

    @Override
    public void init() {
       yourClass = new YourClass();
    }       

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();

        if(yourClass.getBooleanValue) {
           writer.write("true");                
        } else {
           writer.write("false");
        }

        writer.close();
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
    }   
}