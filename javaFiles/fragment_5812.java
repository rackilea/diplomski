@Override protected boolean isAuth()
{
    String authMode = (String)(getSession(true).getAttribute("authMode"));
    if (authMode == null) { return false; }
    if (authMode.equals("open id") {
        //do open id authentication steps here
        //return true if authentication passes
    }
    else if (authMode.equals("some other authentication") {
        //do some other authentication steps here
        //return true if authentication passes
    }
    ...
    return false;    
}