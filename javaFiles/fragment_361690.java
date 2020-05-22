if (renderRequest.getPortletSession(true).getAttribute("set_cookie")!=null){
    return;
}

String cookie_value = renderRequest.getPortletSession(true).getId();
String cookie_hours = "6";

StringBuffer buf = new StringBuffer();
buf.append("\n <script>");
buf.append("\n var today = new Date();");
buf.append("\n var expires_date = new Date ( today.getTime() + (" + cookie_hours + "*1000*60*60) );");
buf.append("\n document.cookie = \"linkedIn=" + util.getAppKey() + ";expires=\"+expires_date.toGMTString();");    
buf.append("\n </script>");

renderResponse.setContentType("text/html");
PrintWriter out = renderResponse.getWriter();
out.println(buf.toString());
renderRequest.getPortletSession(true).setAttribute(SET_COOKIE, cookie_value);