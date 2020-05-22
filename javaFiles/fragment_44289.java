// Prepare download here.
// ...

// Once finished preparing, set cookie.
Cookie cookie = new Cookie("download", request.getParameter("token"));
cookie.setPath("/");
response.addCookie(cookie);

// Now stream download to response.
// ...