package de.scrum_master.aspect;

import de.scrum_master.app.Moody;
import de.scrum_master.app.MyAttribute;

public aspect ITDAspect {
    declare parents : @MyAttribute * implements Moody;
    declare parents : hasmethod(@MyAttribute * *(..)) implements Moody;

    public void Moody.sayHelloTo(String name) {
        System.out.println("Hello " + name);
    }
}