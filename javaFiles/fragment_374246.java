HttpSession session=request.getSession(false);

if(session!=null)
{
    if((session.getAttribute("userid")) != null)
    {
        username = session.getAttribute("userid").toString();
    }
}
System.out.println(username);