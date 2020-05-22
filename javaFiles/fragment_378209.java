public class SetCookieAction 
    implements ServletResponseAware  // needed to access the 
                                     // HttpServletResponse
{

    HttpServletResponse servletResponse;

    public String execute() {
        // Create the cookie
        Cookie div = new Cookie("Tim", "Tim");
        div.setMaxAge(3600); // lasts one hour 
        servletResponse.addCookie(div);
        return "success";
    }


    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

}