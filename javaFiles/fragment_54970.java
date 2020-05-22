package org.example;
public class A {
    private final Logger log; // not static
    public A(Parent p) {
        this.log = LogManager.getLogger(getClass().getName() + "." +
                                        p.getClass().getSimpleName());
    }
}