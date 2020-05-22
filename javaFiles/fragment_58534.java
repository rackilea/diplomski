// ...
Map<String, Cookie> cookieMap = new HashMap<>();
for (Cookie cookie : cookies) {
    cookieMap.put(cookie.getName(), cookie);
}

Cookie firstRequiredCookie = cookieMap.get("<NAME>");
// do something with firstRequiredCookie 
Cookie nextRequiredCookie = cookieMap.get("<ANOTHER_NAME>");
// do something with nextRequiredCookie 
// ...