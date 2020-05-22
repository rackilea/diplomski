protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String link = request.getParameter("link");
     String source = request.getParameter("source");
     LinkDAO dao = new LinkDAO();
     try {
         dao.save(link, source);
     } catch (SQLException e) {
         throw new ServletException("Saving in DB failed", e);
     }
     request.getRequestDispatcher("result.jsp").forward(request, response);
 }