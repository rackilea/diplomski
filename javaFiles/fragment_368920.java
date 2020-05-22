public class MyServlet extends HttpServlet implements Servlet
{
    //...

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        //...
        List listMillesime = MultiMillesimeFactory.getInstance().getListMillesimeActif();
        request.setAttribute("millesime", listMillesime);
        //...
    }

    //...
}