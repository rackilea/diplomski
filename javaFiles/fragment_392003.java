public abstract class AbstractThing {

     public void method1 (Object o) {
         // This is a real method that does things
     }

     // Anyone who extends me must implement this
     public abstract void method2 (Object o1, Object o2);
}

public class ActualThing extends AbstractThing implements List {

    public void add (Object o) {
       // I must implement this method because of the interface List
    }

    public void remove (Object o) {
       // I must implement this method because of the interface List
    }

    public void method2 (Object o1, Object o2) {
       // I must implement this method because of abstract method in
       // the super class
    }