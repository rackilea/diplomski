@WebServlet("/search")
public class SearchServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException{

        request.getRequestDispatcher("/WEB-INF/search.html").forward(request, response);
   }
}