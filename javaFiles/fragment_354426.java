public class MySingletonClass {

    private static MySingletonClass instance;


    public synchronized static MySingletonClass getInstance() {
        if (instance == null) {
            instance = new MySingletonClass(); // "lazy" initialization
        }

        return instance;
    }


   /**
    * private constructor can be called only inside of MySingleton class, but not from    outside.
   */
   private MySingletonClass() {
       // your code here
   }
}