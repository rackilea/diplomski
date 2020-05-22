@Resource
    WebServiceContext webServiceContext;

    public String LogIn(String UserName, String Password, String PhoneNumber) {
     ...
        MessageContext mc = webServiceContext.getMessageContext();
        HttpSession session =    ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
        if (session == null)
             throw new WebServiceException("No Session found");
     ...