name = (request.getParameter("name") != null) ? request.getParameter("name") : "null";

password = (request.getParameter("password") != null)? request.getParameter("password") : "null";

<h3>name:<%=name%></h3>
<h3>password:<%=password%></h3>