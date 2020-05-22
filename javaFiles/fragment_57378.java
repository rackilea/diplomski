public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    // fetch the username that was sent in the request
    String username = request.getParameter("username");

    // TODO: verify if the username is taken in the database

    // based on the results set the value
    request.setAttribute("isUsernameTaken", "true");

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");

    dispatcher.forward(request, response);      
}