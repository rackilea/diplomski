public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    try
    {
        Session session=Hibernate_Class.sessionObject();
        String userID=null;
        userID = request.getParameter("UserId");

        login_model loginModel_Obj=new login_model();
        loginModel_Obj._Name=userID;
        System.out.print("at "+userID);
        boolean username_bool=Hibernate_Class.usernamePresence(loginModel_Obj, session);

        if (username_bool)
        {
            out.println("Username Present In Database");
        }
        else
        {
            out.println("Username Not Present In Database");
        }

    }
    finally{}
    out.close();
}