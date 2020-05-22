import javax.swing.*;

    import com.sun.jna.Native;
    import com.sun.jna.Pointer;
    import com.sun.jna.platform.win32.WinDef.HWND;

    public class main {
       public static void main(String[] args) {
           JFrame jFrame = new JFrame();
           final HWND hwnd = new HWND(Native.getComponentPointer(jFrame));
           System.out.println(hwnd);
       }
    }