protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    try {
        check1();
        check2();
        persist();
    } catch (MyAwesomeException e) {
         handleErroneousRequest(response, e.getMessage());
    }
}