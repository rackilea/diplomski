WebServiceContext wscontext = null;
try {
    Context ctx = new InitialContext();
    wscontext = (WebServiceContext) ctx.lookup("java:comp/WebServiceContext");
} catch (NamingException e) {

}