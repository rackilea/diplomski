RequestDispatcher rd = request.getRequestDispatcher("servlet2");
//Forwards a request from a servlet to another resource (servlet, JSP file,
// or HTML file) on the server.
rd.forward(request,response)

//Includes the content of a resource (servlet, JSP page, HTML file) in the response.
rd.include(request,response)