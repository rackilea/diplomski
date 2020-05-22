Cookie[] cookies = request.getCookies();

if (cookies != null) {
 for (Cookie cookie : cookies) {
   if (cookie.getName().equals("cookieName")) {
     //do something
     //value can be retrieved using #cookie.getValue()
    }
  }
}