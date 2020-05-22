package greetings;

import javax.ejb.Stateless;

@Stateless
public class GreetingsBean implements GreetingsBeanRemote {

    @Override
    public String hi() {
        return "hello world";
    }

    @Override
    public String bye() {
        return "bye";
    }

}