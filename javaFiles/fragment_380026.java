public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    String method = request.getParameter("method");
  if(method.equals("methodA"){
     methodA();
  }else if (method.equals("methodB"){
     methodB();
  }else{
    throw new IllegalArgumentExcpetion("'method' parameter required, must be 'methodA' or 'methodB' !");
  }