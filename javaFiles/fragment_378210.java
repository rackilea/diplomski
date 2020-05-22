public class SetCookieAction 
    implements CookieProvider  // needed to provide the coookies
{

    Set<javax.servlet.http.Cookie> cookies=
            new HashSet<javax.servlet.http.Cookie>();

    public Set<javax.servlet.http.Cookie> getCookies() 
    {
            return cookies;
    }

    public String execute() {
        // Create the cookie
        javax.servlet.http.Cookie div = 
                new javax.servlet.http.Cookie("Tim", "Tim");
        div.setMaxAge(3600); // lasts one hour 
        cookies.put(cookie)
        return "success";
    }

}