String host = remoteHost;
int port = remotePort;
String remoteContext = //the application root you want to access;
String remtoePath =  // the servlet or path you want to access;
if((host.equals(request.getServerName()) || host.equals("localhost")) 
      && port == request.getServerPort(){
   ....
  ServletContext context = servletContext.get(remoteContext);
  RequestDispatcher dispatcher = context.getRequestDispatcher(remotePath);
     //if you want to forward
  //dispatcher.forward(request, response);
     //if you want to include
  //dispatcher.include(request, response);

}