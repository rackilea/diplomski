@RequestMapping(value = "/api/v1/User", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
public String getBySomeAttribute(@RequestParam(value = "someAttribute", required = true) String someAttribute,
                                HttpServletResponse response) {
    User user = service.getBySomeAttribute(someAttribute);
    return createResponse(user, response);
}

private String createResponse(User user, HttpServletResponse response) {
    String responseBody = "";
    if(user != null && user.getEnabled()) {
        String responseBody = toJsonString(userJsonMapper.jsonMapFrom(user))
        response.setStatus(SC_OK);
    }

    setResponseHeaders(response, responseBody.length());
    return responseBody;
}

private void setResponseHeaders(HttpServletResponse response, int responseBodySize) {
    response.setHeader("Content-Length", valueOf(responseBodySize));
    response.setHeader("Expires", "1");
    response.setHeader("Cache-Control", "no-cache");
}