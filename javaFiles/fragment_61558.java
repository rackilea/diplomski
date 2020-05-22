import com.sun.jna.Memory;

public class TinyJavaBigC {
    public static void main(String[] args) {
        // Grab 1 GiB of memory
        Memory buf = new Memory(1 << 30);
        // Sleep long enough to grab ps
    }
}