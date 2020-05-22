Cookie[] cookies = req.getCookies();
if (cookies != null)
    for (int i = 0; i < cookies.length; i++) {
        cookies[i].setValue("");
        cookies[i].setPath("/");
        cookies[i].setMaxAge(0);
        resp.addCookie(cookies[i]);
    }