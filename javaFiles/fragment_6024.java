@Override
protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
   // ... code to build your values

   // Set the values
   request.setAttribute("welshName", welshName);
   request.setAttribute("englishName", englishName);
   request.setAttribute("gender", gender);

   // Ask the view to take care of the values
   request.getRequestDispatcher("view.jsp").forward(request, response);
}