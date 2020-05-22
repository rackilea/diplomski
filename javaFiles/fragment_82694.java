@Resource
private WebServiceContext context;

@WebMethod
public String hello() {
    Principal user = context.getUserPrincipal();
    return (user != null) ? user.getName() : "(not logged in)";
}