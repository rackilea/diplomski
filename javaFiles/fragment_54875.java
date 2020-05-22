import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.*; 
import com.sun.jna.examples.win32.Kernel32;

...

public static boolean isLocalSession() {
  Kernel32 kernel32;
  IntByReference pSessionId;
  int consoleSessionId;
  Kernel32 lib = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
  pSessionId = new IntByReference();

  if (lib.ProcessIdToSessionId(lib.GetCurrentProcessId(), pSessionId)) {
    consoleSessionId = lib.WTSGetActiveConsoleSessionId();
    return (consoleSessionId != 0xFFFFFFFF && consoleSessionId == pSessionId.getValue());
  } else return false;
}