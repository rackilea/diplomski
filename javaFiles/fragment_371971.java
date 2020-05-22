import java.io.Serializable;
import com.sun.jna.WString;

public interface AutoITX extends com.sun.jna.Library, Serializable {

public static int AU3_INTDEFAULT = -2147483647;

public int AU3_WinWaitActive(WString szTitle, WString szText, int nTimeout);

    }