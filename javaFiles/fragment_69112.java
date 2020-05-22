<%
     Cookie killMyCookie = new Cookie("mycookie", null);
     killMyCookie.setMaxAge(0);
     killMyCookie.setPath("/");
     response.addCookie(killMyCookie);
%>