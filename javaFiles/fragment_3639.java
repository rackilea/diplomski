public class Tail-recursion{
   public static void tail(int i) {
      if(i>0){
        System.out.print (i +"");
        tail(i-1);
      }
   }   
}  // and here