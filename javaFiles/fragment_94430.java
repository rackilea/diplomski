import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;

    public class GetCPUInfosUsingJNA {

        // https://github.com/twall/jna#readme
        //  you need 2 jars : jna-3.5.1.jar and platform-3.5.1.jar

        public static void main(String ... args) {
          System.out.println(Advapi32Util.registryGetStringValue
             (HKEY_LOCAL_MACHINE,
                "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0\\",
              "ProcessorNameString"));   
          System.out.println(Advapi32Util.registryGetStringValue
                  (HKEY_LOCAL_MACHINE,
                     "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0\\",
                   "Identifier"));        
        }
    }