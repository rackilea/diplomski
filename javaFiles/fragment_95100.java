@GET
public void getHome(@Context HttpServletRequest request, @Context HttpServletResponse response) {
    try {
        ...
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    } catch (ServletException | IOException e) {
        LOG.log(Level.SEVERE, "There was an error getting the ...", e);
    }
}