package hello;

import javax.ejb.Stateless;

@Stateless
public class HelloBean implements HelloBeanRemote {

    @Override
    public String Hi() {
        return "hello world";
    }

    @Override
    public String Bye() {
        return "goodbye";
    }

}