<%    
  String timeStamp = new SimpleDateFormat("dd:MM:yyyy_HH:mm:ss:SSS").format(Calendar.getInstance().getTime());
  timeStamp = timeStamp + ":" + System.nanoTime();
  HttpSession ses = request.getSession();
  if(ses == null || ses.getAttribute("path") == null)
{
  session.setAttribute("path", timeStamp);
}
  else
{
  session.getAttribute("path");
}
 %>