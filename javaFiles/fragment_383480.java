import com.sun.jna.platform.win32.*;
import java.text.MessageFormat;

public static void main(String args[]) {
    Kernel32 kernel = Kernel32.INSTANCE;
    WinNT.OSVERSIONINFOEX vex = new WinNT.OSVERSIONINFOEX();
    if (kernel.GetVersionEx(vex)) {
        System.out.println(MessageFormat.format("{0}.{1}.{2}",
            vex.dwMajorVersion.toString(),
            vex.dwMinorVersion.toString(),
            vex.dwBuildNumber.toString()));
    }
}