import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Kernel32 extends Library
{
    public void OutputDebugStringA(String Text);
}