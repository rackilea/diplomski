package greetings;

import javax.ejb.Remote;

@Remote
public interface GreetingsBeanRemote {

    public String hi();

    public String bye();
}