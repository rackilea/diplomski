@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session= req.getSession();
        session.invalidate();
        RequestDispatcher rd = req.getRequestDispatcher("/login.xhtml"); //The url where go after logout
        rd.forward(req,res);
  }
}