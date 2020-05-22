package org.paulvargas.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
    String sayHello(String name);
}