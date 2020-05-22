<% 
    HttpServlet servlet = ServletManager.get(request.getParameter("controller"));

    if (servlet != null) {
        servlet.service(request, response);
    } else {
        // Handle non existing controller.
    }
%>