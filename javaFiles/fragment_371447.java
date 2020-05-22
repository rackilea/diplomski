protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    if (!check1()) {
        handleErroneousRequest(response, "Error 1");
        return;
    }

    if (!check2()) {
        handleErroneousRequest(response, "Error 2");
        return;
    }

    persist();

}