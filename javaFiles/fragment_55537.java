while (rs.next())
{
  HttpSession session = request.getSession(true);
  String tmp = rs.getString(1);
  System.out.println(tmp);
  session.setAttribute("username", tmp); 
  count++;
 }