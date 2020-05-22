public class AccountServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<Account> accounts = getAccountListFromSomewhere();

    String url="..."; //relative url for display jsp page
    ServletContext sc = getServletContext();
    RequestDispatcher rd = sc.getRequestDispatcher(url);

    request.setAttribute("accountList", accounts );
    rd.forward(request, response);
  }
}