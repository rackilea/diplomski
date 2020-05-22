protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user = (User) request.getSession().getAttribute("userInfo");
    MyThreadLocal.set(user);
    try {
       // call data layer
    } finally {
        MyThreadLocal.unset();
    }
}