package hello;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
    public String Hi();
    public String Bye();
}