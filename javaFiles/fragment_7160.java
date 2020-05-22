<% 
 String uri = request.getRequestURI();
 String pageName = uri.substring(uri.lastIndexOf("/")+1);
 if( !"home.html".equals(pageName) )
 {
    out.print("<script src='" + designPath + "/javascripts/constants.js' type='text/javascript'></script>");
    out.print("<script src='" + designPath + "/javascripts/application.js' type='text/javascript'></script>");
    out.print("<script src='" + designPath + "/javascripts/cart.js' type='text/javascript'></script>");
 }
 %>