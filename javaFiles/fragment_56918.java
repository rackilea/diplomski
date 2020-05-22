public class Program {    
    public static void main(String[] args) { 
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {        
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("Uhhh something broke.");    
            }
        });

        int a = 5 / 0; 
    }
}