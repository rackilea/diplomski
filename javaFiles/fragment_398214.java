public class Foo {

    public void myMethod(){    

       Thread thread1 = new Thread() {
          public void run() {

          }
       };

       Thread thread2 = new Thread() {
         public void run() {

        }
       };

       thread1.start();
       thread2.start();
    }

}