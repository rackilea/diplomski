protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    User user = new User();
    user.setName("Jitendra");
    request.setAttribute("user", user); // Store in request scope.
    request.getRequestDispatcher("/WEB-INF/show.jsp").forward(request, response);
}