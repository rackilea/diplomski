@RequestMapping(value = "/", method = RequestMethod.GET)
public String handleMyGetRequest(HttpServletRequest request) {
    // Reading the value of one specific parameter ...
    String value = request.getParameter("myParam");

    // or all parameters 
    Map<String, String[]> params = request.getParameterMap();

    ...
}