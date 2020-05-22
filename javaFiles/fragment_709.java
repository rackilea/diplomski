import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Callback;
import com.sun.jna.ptr.PointerByReference;

interface InterestingEvent extends Callback
{
    public void interestingEvent(int id, String P1);
}

class MyCallback implements InterestingEvent {
    @Override
    public void interestingEvent(int id, String P1) {
        System.out.print("The the event "+ id + " throw this error: " + P1 + "\n");
    }
}

public class Main{

    public interface Kernel32 extends Library {
        public void S11(int id, String P1, InterestingEvent callback);
        public void Get_P1(int id, PointerByReference P1);
        }

    public static void main(String[] args) {
        Kernel32 lib = (Kernel32) Native.loadLibrary("path\\to\\dll",
                Kernel32.class);
        lib.S11(id, "some string", new MyCallback() );

        PointerByReference p = new PointerByReference();
        lib.Get_P1(id, p);
        String str = p.getValue().getString(0);
    }
}