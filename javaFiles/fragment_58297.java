@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        doSomethingWhichMayThrowException();
    } catch (NotARuntimeException e) {
        throw new ServletException(e);
    }
}