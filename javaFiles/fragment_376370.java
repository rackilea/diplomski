package myapp;

import net.sourceforge.stripes.action.*;

@UrlBinding("/Welcome.action")
public class WelcomeActionBean extends MyAppActionBean {
    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/jsp/welcome.jsp");
    }
}