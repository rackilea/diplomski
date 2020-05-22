package org.foo.examples;

import org.foo.annotations.Funky;

public class AnnotatedClass {
    @Funky
    private  String   funkyString;
    private  String   nonFunkyString;
    @Funky
    private  Integer  funkyInteger;
    private  Integer  nonFunkyInteger;
}