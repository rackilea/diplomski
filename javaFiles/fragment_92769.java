protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String postId = request.getPathInfo();
    // Do your business thing here. Any results can be placed in request scope. E.g.
    request.setAttribute("post", post); // post is a bean containing information you'd like to display in JSP.
    // Then forward request to JSP file.
    request.getRequestDispatcher("/WEB-INF/posts.jsp").forward(request, response);
}