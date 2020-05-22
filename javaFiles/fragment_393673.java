HttpSession session = request.getSession(false);
if(session==null || !request.isRequestedSessionIdValid() )
{
    //comes here when session is invalid.

}