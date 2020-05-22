@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String details = detailsLoader.loadDetails(String.valueOf(request.getParameter("value1")),
            String.valueOf(request.getParameter("value2")));

    response.getWriter().println(details);
    response.getWriter().flush();
    response.getWriter().close();
}