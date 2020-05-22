public class subclass {
 public receive(){
     //some code
 }

 public static void main(String args[]){
    Superclass superTst = new Superclass(new subclass());
    superTst.start();
    // ...
 }
}