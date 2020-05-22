public class MySingleton{

   private MySingleton(){

   }

   public static MySingleton getInstance(){
       return SingletonCreator.INSTANCE;
   }

   private static class SingletonCreator{
     private static final MySingleton INSTNACE = new MySingleton();
   }
}