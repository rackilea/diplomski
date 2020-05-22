package helloclient;

import hello.HelloBeanRemote;
import javax.ejb.EJB;

public class Main {
    @EJB
    private static HelloBeanRemote helloBean;

    public static void main(String... args) {
        System.out.println(helloBean.Hi());
    }

}