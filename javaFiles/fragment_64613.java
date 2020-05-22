public class ThreadLocalContainer {
   private static ThreadLocal<String> userId=new ThreadLocal<String>();
   public static String getUserId(){
       return userId.get();
   }
   public static void setUserId(String uid){
        userId.set(uid);
   }
   public static void resetUserId(){
        userId.remove();
   }
}