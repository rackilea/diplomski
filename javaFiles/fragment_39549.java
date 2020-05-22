protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    String shared = "shared";
    request.setAttribute("sharedId", shared); // add to request
    request.getSession().setAttribute("sharedId", shared); // add to session
    this.getServletConfig().getServletContext().setAttribute("sharedId", shared); // add to application context
    request.getRequestDispatcher("/URLofOtherServlet").forward(request, response);
}