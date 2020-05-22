<%
  User user = (User) pageContext.findAttribute("user");
  if (user != null) {
    String name = user.getName();
    if (name != null) {
      out.print(name);
    }
  }
%>