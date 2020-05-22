//inside doPost method

    request.setAttribute("count", request.getParameter("table");

    // redirect to jsp 

    String nextJSP = "/table.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    dispatcher.forward(request,response);