//in your login servlet, on successful login
request.getSession().setAttribute("LOGGED_USER", userObject);

//in your security filter
if(request.getSession().getAttribute("LOGGED_USER") == null){
//optionally, you may like to check if that attribute has a valid userId as well
     RequestDispatcher rd = request.getRequestDispatcher("relative/path/to/login/servlet")
     rd.forward(request, response);
     return;
}