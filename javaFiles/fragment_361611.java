public static String getUrl(HttpServletRequest req) {
String reqUrl = req.getRequestURL().toString();
String queryString = req.getQueryString();
if (queryString != null) {
    reqUrl += "?"+queryString;
}
return reqUrl;