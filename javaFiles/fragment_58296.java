@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        doSomethingWhichMayThrowException();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
        throw e;
    }
}