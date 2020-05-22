protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException {
  HttpSession session = req.getSession(true);
  // get counter variables
  Integer smartCtr = session.getAttribute("smart") == null? 0: session.getAttribute("smart");
  Integer globeCtr = session.getAttribute("globe") == null? 0: session.getAttribute("globe");
  Integer sunCtr = session.getAttribute("sun") == null? 0: session.getAttribute("globe");
  //your logic
  ....
  //set incremented values back
  session.setAttribute("smart", smartCtr);
  .....
}