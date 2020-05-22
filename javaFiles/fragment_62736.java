String fpath = request.getSession().getAttribute("path").toString();
HttpSession session = request.getSession();
session.setAttribute("path", fpath);

    //Did my file upload stuff using apache commons

    RequestDispatcher rd = request.getRequestDispatcher("my.jsp");
rd.forward(request, response);