package edu.home.control;

public class ControlClass {
    //this line compiles fine
    private TheClass x;
    //compilation error, it can't access for being in a different package
    private AnotherClass y;
    //compilation error, it can't access because its scope works only in TheClass
    private SomeClass z;
}