public void doSomeUrl(StaplerRequest request, StaplerResponse response) {
    Cookie[] myCookies = request.getCookie();
    doSometingBasedOnCookies(myCookies);
    response.setStatus(200);
    response.setContentType("application/json;charset=UTF-8");
    String myJson = getJson();
    response.getWriter().print(myJson);
}