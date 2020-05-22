@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer left = Integer.valueOf(request.getParameter("left"));
    Integer right = Integer.valueOf(request.getParameter("right"));
    Integer sum = left + right;

    request.setAttribute("sum", sum); // It'll be available as ${sum}.
    request.getRequestDispatcher("calculator.jsp").forward(request, response); // Redisplay JSP.
}