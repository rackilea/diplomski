public class Singleton {
    private static volatile Singleton instance = null;
    private static File file1;
    ... 


    private Singleton() 
    {  
        //Load whatever you need here.
    }

    public static Singleton getInstance() {
            if (instance == null) {
                    synchronized (Singleton.class)
                            if (instance == null) {
                                    instance = new Singleton();
                            }
            }
            return instance;
    }

   ...
   //Other getter and setters for your files and other objects