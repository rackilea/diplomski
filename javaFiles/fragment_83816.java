if (request.getMethod().equals("OPTIONS")) {
  try {chain.doFilter(req, res);} 
  catch (IOException e) {e.printStackTrace();} 
  catch (ServletException e) {e.printStackTrace();}
} 
else {    }