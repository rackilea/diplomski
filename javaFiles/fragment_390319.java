<%
UserBean u = new UserBean();
DataBean d = new DataBean(u);

u.setUsername("John");
out.println(u.getUsername());
out.println(d.getUsernameTwo());
%>