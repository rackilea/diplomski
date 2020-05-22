<% HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user2", user2);
    %>

    then from any jsp page u can access that attribute for same session like this

   <%HttpSession httpSession=request.getSession();
         httpSession.getAttribute("user2");
   %>