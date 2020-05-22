import com.sun.jna.Native;

public class Program {
    private static final int SW_RESTORE = 9;

    public static void main(String[] args) {
        User32 user32 = Native.loadLibrary("User32.dll", User32.class);
        int window = user32.FindWindowA(null, "Google Chrome");
        boolean success = user32.ShowWindow(window, SW_RESTORE);
        if (success) {
            System.out.println("Success");
        } else {
            System.out.println("Fail: " + Native.getLastError());
        }
    }
}