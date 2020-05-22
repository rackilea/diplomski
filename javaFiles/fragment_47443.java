public class ScopeExample

    int classInt = 10;

    public void method() {
        int methodInt = 0; // This integer can only be seen by code in 
                           // this method
    }

    public void method2() {
        //doSomething(methodInt) // This line won't compile because i is 
                                 // declared in a different method!
        doSomething(classInt); // This line will compile and work 
                               // because x is declared in the class that 
                               // contains this method.
        int index = 0;
        while (index < 3) {
            int whileInt = index; // This integer can only be seen from within 
                                  // this while loop! It is created each 
                                  // loop iteration.
            doSomething(whileInt);
        }
        doSomething(whileInt); //This line won't work, whileInt is out of scope!
    }

    public doSomething(int a) {
        System.out.println(a);
    }

}