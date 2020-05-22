@Component
public class mySessionListener implements javax.servlet.http.HttpSessionListener{

   @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

    SecurityContextImpl springSecurityContext = (SecurityContextImpl)session.getAttribute("SPRING_SECURITY_CONTEXT");
    if(springSecurityContext!=null){
        Authentication authentication = springSecurityContext.getAuthentication();
        LdapUserDetails userDetails = (LdapUserDetailsImpl)authentication.getPrincipal();
     //track user logout here

}
...