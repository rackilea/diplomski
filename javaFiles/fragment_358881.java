public class MyThing {

     private MyThing() { // private constructor
     };

     public static MyThing thing() {
         return new MyThing();
     }
}