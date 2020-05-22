public void doPost(HttpServletRequest request, HttpServletResponse response) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = new UserService().login(username, password);
    if (user != null) {
        //success!
        //save the user data in session scope
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        //do your forward or redirect...
    }
    //do your forward or redirect to show error messages...
}