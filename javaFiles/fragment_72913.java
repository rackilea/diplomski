public class MyException extends Exception {

 public MyException() {

     super();

 }

 public MyException(String msg){

    super(msg);

 }

 public MyException(String msg, Exception cause){
     super(msg, cause);
 }

 public static void main(String[] args) {

     try {

         throw new MyException();

     } catch (Exception e) {

         System.err.println(e.getMessage());
     }
 }

}