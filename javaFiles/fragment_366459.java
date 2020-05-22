public class Xapp extends App {
     private A a;
     private B b;
     private C c;

     private Xapp() {
        // do anything
     }

     public static Xapp newInstance() {
         Xapp x = new Xapp();
         x.doStuff();
         return x
     }

     // snip...

}