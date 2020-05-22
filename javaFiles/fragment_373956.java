<%

    javax.servlet.http.Cookie cookie 
           = new javax.servlet.http.Cookie("name", "value");

    // cookie.setXXX()

    response.addCookie(cookie);

%>