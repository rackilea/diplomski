public class Outer {
     public static class NestedStatic implements Runnable {

         public void run(){
             doSomething();

         }
     public static void main(String[] args){
         Thread nestThread=new Thread(new NestedStatic());
         nestThread.start();

         // now anonymous:
         Thread anonThread=new Thread(new Runnable(){
             public void run(){
                 doSomethingElse();
             });
         anonThread.start(); 
     }
}