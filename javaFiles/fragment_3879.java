public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("abs") && password.equals("abs")){
            RequestDispatcher rd = request.getRequestDispatcher("Welcome");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("Error");
            rd.forward(request, response);            
        }
    }
}