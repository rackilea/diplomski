import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.win32.StdCallLibrary;

public interface Ole32 extends StdCallLibrary {

    Ole32 INSTANCE = (Ole32) Native.loadLibrary("Ole32", Ole32.class);

    public HRESULT CoInitialize(Pointer p);

    public HRESULT CoUninitialize();

}