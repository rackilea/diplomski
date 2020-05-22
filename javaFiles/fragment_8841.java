public class Caller {

     private boolean someState;

     // ...

     public void doSomething() {
         // the method call
         Worker w = new Worker(this);
         int result = w.workForMe();
     }

     public void setState(boolean state) {
         this.someState = state;
     }

}