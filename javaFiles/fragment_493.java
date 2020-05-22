package net.bounceme.dur.jndi;

import greetings.GreetingsBeanRemote;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteJNDI {

    private static final Logger log = Logger.getLogger(RemoteJNDI.class.getName());

    public static void main(String... args) {
        try {
            InitialContext ctx = new InitialContext();
//            Object obj = ctx.lookup("java:global/HelloEAR/HelloEAR-ejb/greetings.GreetingsBeanRemote");
            Object obj = ctx.lookup("greetings.GreetingsBeanRemote");
            GreetingsBeanRemote gbr = (GreetingsBeanRemote) obj;
            System.out.println(gbr.hi());
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

}