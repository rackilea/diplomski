Cookie name1 = new Cookie("name1", "value1");
name1.setPath("/path");
name1.setSecure(true);
name1.setHttpOnly(true);

Cookie name2 = new Cookie("name2", "value2");
name2.setPath("/");
name2.setMaxAge(secondsUntil3Jun2012);

response.addCookie(name1);
response.addCookie(name2);