public void doGet(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException  {

     RequestDispatcher rd = request.getRequestDispatcher("jsp/doactiontwo.jsp");
     rd.forward(request, response);
}