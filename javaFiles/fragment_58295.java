@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        doSomethingWhichMayThrowException();
    } catch (IllegalArgumentException e) {
        e.printStackTrace(); // Or something else which totally suppresses the exception.
    }
}