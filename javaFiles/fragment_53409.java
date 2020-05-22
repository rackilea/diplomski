//handles callback url
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
{  //...
   TwiMLResponse twiml = new TwiMLResponse();
   String callSid = request.getParameter("CallSid");
   //handle call specific data
   switch(request.getParameter("CallStatus")){
      case "no-answer": //construct twiML
      case "ringing" ://...
    }
    //...
   response.setContentType("application/xml");
   response.getWriter().print(twiml.toXML());
}