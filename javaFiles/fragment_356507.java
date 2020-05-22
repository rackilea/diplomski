package externalPackage;

import mainPackage.MainClass;

public class SomeClass {

    public void foo() {
        MainClass foo = new MainClass() { 
        // doesn't work because `MainClass` is not visible
        };
    }

}