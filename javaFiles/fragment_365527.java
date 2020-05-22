@WebServlet(urlPatterns = "/serv")
public class Serv extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("serv2");
        dispatcher.include(request, response);
        if (request.getAttribute("Successful") != null
                && (boolean) request.getAttribute("Successful")) {
            System.out.println("Success!");
        } else {
            System.out.println("No success!");
        }
    }
}