public LogoutServlet extends HttpServlet {
    @Override
    public void doGet(...) {
       request.getSession().invalidate();
    }
}