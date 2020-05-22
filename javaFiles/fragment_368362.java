import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallLibrary;

public class TestThisDLL {
    public interface PenniesLib extends StdCallLibrary {
        PenniesLib INSTANCE = (PenniesLib) Native.loadLibrary(
            "PenniesLib", PenniesLib.class);
        int a();
    }

    public static void main(String[] args) {
        int value = PenniesLib.INSTANCE.a();
        System.out.println(value);
    }
}