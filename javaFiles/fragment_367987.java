package com.javamad.model;

import org.codehaus.jackson.annotate.JsonIgnore;



public class Sample{
     int foo=5;
     public int getFoo() {
        return foo;
    }
    public void setFoo(int foo) {
        this.foo = foo;
    }
    @JsonIgnore
    public int getBar() {
        return bar;
    }
    public void setBar(int bar) {
        this.bar = bar;
    }
    int bar=6;
    }