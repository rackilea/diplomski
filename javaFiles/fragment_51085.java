class PrivateCons{
   private PrivateCons(){
    System.out.println("I'm executed");
   }
}

public class Test{
   public static void main(String[] args) {
      PrivateCons p=new PrivateCons(); //this will fail- compiler error
      PrivateCons q=new PrivateCons();//this will fail- compiler error
   }
}