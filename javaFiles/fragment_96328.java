import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;

public class TurnOffMonitor {
   public interface User32 extends StdCallLibrary {
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      int SC_MONITORPOWER = 0xF170;
      int SC_MONITOR_OFF = 2;
      int SC_MONITOR_ON = -1;

      LRESULT SendMessageA(HWND paramHWND, int paramInt, WPARAM paramWPARAM,
            LPARAM paramLPARAM);

      LRESULT SendMessageA(HWND paramHWND, int paramInt, int paramInt2,
            LPARAM paramLPARAM);
   }

   private static final long SLEEP_TIME = 4 * 1000; // 4 seconds

   public static void main(String[] args) {
      final User32 user32 = User32.INSTANCE;
      System.out.println("Foo");

      user32.SendMessageA(WinUser.HWND_BROADCAST, WinUser.WM_SYSCOMMAND,
            User32.SC_MONITORPOWER, new LPARAM(User32.SC_MONITOR_OFF));

      try {
         Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {}

      user32.SendMessageA(WinUser.HWND_BROADCAST, WinUser.WM_SYSCOMMAND,
            User32.SC_MONITORPOWER, new LPARAM(User32.SC_MONITOR_ON));

   }
}