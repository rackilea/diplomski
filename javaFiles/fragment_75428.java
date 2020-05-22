public Set<Cookie> getCookies(){
      Set<Cookie> cookies = new HashSet<>();
      User user = (User) session.get("user");
      if (user != null){
          Cookie userId = new Cookie("userId", user.getUserId() );
          userId.setMaxAge(60*60*24*365); // Make the cookie last a year!
          userId.setPath("/"); //Make it at root.
          cookies.add(userId);
      }
      return cookies;
}