public class AddUserServlet extends HttpServlet {

private DBJoint db;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    db = (DBJoint) getServletContext().getAttribute("db");

    String Name = request.getParameter("name");
    String Login= request.getParameter("login");
    String Email= request.getParameter("email");

    db.getDBExecutor().addUser(
        new User(Name, Login, Email);

    //And you need to 'serverAnswer' item in your 'answer.jsp' you know.
    request.setAttribute("serverAnswer", "Add ok!");
    request.getRequestDispatcher("answer.jsp").forward(req, resp);
    }    
}