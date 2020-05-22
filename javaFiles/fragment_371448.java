protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    if (!check1()) {
        handleErroneousRequest(response, "Error 1");
    } else if (!check2()) {
        handleErroneousRequest(response, "Error 2");
    } else {
        persist();
    }
}