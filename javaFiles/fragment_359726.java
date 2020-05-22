protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {            
    request.setAttribute("message", "hello");
    RequestDispatcher view=request.getRequestDispatcher("index.jsp");
    view.forward(request,response);
}