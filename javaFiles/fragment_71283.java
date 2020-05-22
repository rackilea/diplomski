import java.io.*;
import com.sun.jna.*;

public class Ren {

  static interface Kernel32 extends Library {
    public static Kernel32 INSTANCE = (Kernel32) Native
        .loadLibrary("Kernel32", Kernel32.class);

    public static int FORMAT_MESSAGE_FROM_SYSTEM = 4096;
    public static int FORMAT_MESSAGE_IGNORE_INSERTS = 512;

    public boolean MoveFileW(WString lpExistingFileName,
        WString lpNewFileName);

    public int GetLastError();

    public int FormatMessageW(int dwFlags,
        Pointer lpSource, int dwMessageId,
        int dwLanguageId, char[] lpBuffer, int nSize,
        Pointer Arguments);
  }

  public static String getLastError() {
    int dwMessageId = Kernel32.INSTANCE.GetLastError();
    char[] lpBuffer = new char[1024];
    int lenW = Kernel32.INSTANCE.FormatMessageW(
        Kernel32.FORMAT_MESSAGE_FROM_SYSTEM
            | Kernel32.FORMAT_MESSAGE_IGNORE_INSERTS, null,
        dwMessageId, 0, lpBuffer, lpBuffer.length, null);
    return new String(lpBuffer, 0, lenW);
  }

  public static void main(String[] args) throws IOException {
    String from = ".\\from.txt";
    String to = ".\\to.txt";
    new FileOutputStream(from).close();
    if (!Kernel32.INSTANCE.MoveFileW(new WString(from),
        new WString(to))) {
      throw new IOException(getLastError());
    }
  }
}