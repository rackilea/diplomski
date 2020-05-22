public class Singleton {

   static {
      System.out.println("In Singleton static block.");
   }

   private static final Singleton INSTANCE = new Singleton();

   public static Singleton getInstance() {
      System.out.println("In getInstance().");
      return INSTANCE;
   }

   private Singleton() {
      System.out.println("In constructor.");
   }

   private void doSomething() {
      System.out.println("Singleton working.");
   }

   public static void main(String[] args) {
      System.out.println("Start of main.");
      Singleton.getInstance().doSomething();
      System.out.println("End of main.");
   }

}