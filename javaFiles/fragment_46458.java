Cookie loginCookie = null;
Cookie[] cookies = request.getCookies();
if(cookies != null) {
   for(Cookie cookie : cookies){
      if(cookie.getName().equals("uid")){
         loginCookie = cookie;
         break;
      }
   }
}
if(loginCookie != null){
   loginCookie.setMaxAge(0);
   response.addCookie(loginCookie);
}
response.sendRedirect("index.html");