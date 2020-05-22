public class Test2 {
     public static void main(String args[]) {
        new Test2().doit();
     }
     public void doit() {
        System.out.println(
           Thread.currentThread().getStackTrace()[1].getMethodName()); // output : doit
     }
   }