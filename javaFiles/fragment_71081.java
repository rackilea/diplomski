package org.paulvargas.ejb;

import javax.ejb.Local;

@Local
public interface HelloLocal {
    String sayHello(String name);
}