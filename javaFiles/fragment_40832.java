public class BaseResource {

    protected HttpServletRequest hsr;

    /* ... */

    public BaseResource(HttpServletRequest hsr) {
        this.hsr = hsr;

        String username = (String)hsr.getAttribute("auth_username");
        System.out.println("constructur of BaseResource" + username);   
    }    
}