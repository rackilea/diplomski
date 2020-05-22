public class MyServlet extends HttpServlet {

    @Override
    public void doPost(final HttpServletRequest request, 
                       final HttpServletResponse response) throws ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }
}