import java.util.*;
import com.sun.jna.*;
import com.sun.jna.win32.*;
//
public class Test
  {
  public interface mydll extends StdCallLibrary
    {
    mydll INSTANCE = Native.loadLibrary("mydll", mydll.class, new HashMap {{
      put("myfunc", "myfunc@8");
      //Other functions
      }});
    public int myfunc (long arg);
    //Other functions
    }
  //
  public static void main (String[] args)
    {
    System.out.println
      (mydll.INSTANCE.myfunc((long)0x23A3920F)); //Or whatever
    return 0;
    }
  }