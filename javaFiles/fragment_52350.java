@WebServlet("index.jsp")
public class IndexServlet extends HttpServlet {
    //using ... to avoid parameters and exceptions to be thrown
    @Override
    public void doGet(...) throws ... {
        //this method should only forward to your view
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    //using ... to avoid parameters and exceptions to be thrown
    @Override
    public void doPost(...) throws ... {
        //current implementation...
        //in the end, forward to the same view
        request.setAttribute("message", "Upload Sucedded!");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}