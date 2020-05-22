public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
     @Override
     public void uncaughtException(Thread thread, Throwable ex) {
     if(ex.getClass().equals(OutOfMemoryError.class))
     {
     try {
       android.os.Debug.dumpHprofData("/sdcard/dump.hprof");
     } 
     catch (IOException e) {
       e.printStackTrace();
     }
     }
     ex.printStackTrace();
     }
}