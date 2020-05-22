public void service(HttpServletRequest req, HttpServletResponse res) 
 throws IOException {
   String ip = req.getRemoteAddr();
   Date date = new Date();
   MyLogger.log(ip,date);
  }