package keylogger;

public class TestKeys {
private static int i = 0;
private native void setWinHook();
private native void unregisterWinHook();
private native void createWinThread();
private native void stopNativeThread();

public static void main(String args[]) {
    TestKeys o = new TestKeys();
    try {
        Thread.sleep(5000);
    }catch(Exception exc) {
        exc.printStackTrace();
    }
   o.stopNativeThread();
   o.unregisterWinHook();
   System.out.println("Native thread stopped and Hook unregistered !");

   try {
        Thread.sleep(3000); // Now you won't see the message : you pressed the key 
    }catch(Exception exc) {
        exc.printStackTrace();
    }
}

static {
    System.loadLibrary("MyHook");
}
}