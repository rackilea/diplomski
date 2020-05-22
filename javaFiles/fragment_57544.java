String username = request.getParameter("username");
String password = request.getParameter("password");
User user = userDAO.find(username, password);
if (user != null) {
    request.getSession().setAttribute("user", user);
    response.sendRedirect("home");
} else {
    request.setAttribute("error", "Unknown login, please try again.");
    request.getRequestDispatcher("login").forward(request, response);
}