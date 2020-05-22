protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, String> messages = new HashMap<String, String>();
    request.setAttribute("messages", messages); // Will be available by ${messages}.

    String username = request.getParameter("username");
    if (username == null  || username.trim().isEmpty()) {
        messages.put("username", "Please enter username");
    }

    // ...

    request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
}