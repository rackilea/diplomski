String username = request.getPathInfo().substring(1);
User user = userDAO.find(username);

if (user != null) {
   request.setAttribute("user", user);
   request.getRequestDispatcher("/WEB-INF/userindex.jsp").forward(request, response);
} else {
   // Show "unknown user" error page or whatever.
}