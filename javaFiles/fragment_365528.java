@WebServlet(urlPatterns = "/serv2")
public class Serv2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("Successful", true);
    }
}