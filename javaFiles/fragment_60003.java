@WebServlet("/Hello")
public class Hello extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 482093033327453159L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Account acc = new Account();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Account before withdraw: " + acc.balance + "<br/>");
        acc.withdraw(10);
        out.println("Account after withdraw: " + acc.balance + "");
        out.close();
    }
}