import com.sun.jna.*;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.*;

public class JnaTest {
   public interface User32 extends StdCallLibrary {
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      HWND GetForegroundWindow();  // add this
      int GetWindowTextA(PointerType hWnd, byte[] lpString, int nMaxCount);
   }

   public static void main(String[] args) throws InterruptedException {
      byte[] windowText = new byte[512];

      PointerType hwnd = User32.INSTANCE.GetForegroundWindow(); // then you can call it!
      User32.INSTANCE.GetWindowTextA(hwnd, windowText, 512);
      System.out.println(Native.toString(windowText));
   }
}