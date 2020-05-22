package org.paulvargas.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService
public class HelloBean implements HelloRemote, HelloLocal {
    public String sayHello(String name) {
        return "Hello, " + name + ".";
    }
}