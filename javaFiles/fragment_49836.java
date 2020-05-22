protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        List<Row> rows = someDAO.list();
        request.setAttribute("rows", rows);
    } catch (SQLException e) {
        request.setAttribute("error", "Retrieving rows failed.");
        e.printStackTrace();
    }
    request.getRequestDispatcher("page.jsp").forward(request, response);
}