public class BaseResource {

    @Context
    protected HttpServletRequest hsr;

    /* ... */

    protected String getUsername() {
        return (String)hsr.getAttribute("auth_username");
    }    
}