public class A {
    public int f(int p){
    {
         B obj = new B();
         try {
             obj.g(p);
         } catch ( /* the exception */ ) {
             // handle the exception
         }
    }
}

public class B {
    public int g(int p)
    {
        // throws an exception for this value of p
    }
}