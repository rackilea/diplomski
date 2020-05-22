public interface IPlatformAPI {
        public void print( String str );
    }

    public class WindowsPlatformAPI implements IPlatformAPI {
        public void print( String str ) { ... }
    }

    public class MacPlatformAPI implements IPlatformAPI {
        public void print( String str ) { ... }
    }

    public class LinuxPlatformAPI implements IPlatformAPI {
        public void print( String str ) { ... }
    }

    public class PlatformAPI {
       public static IPlatformAPI getPlatformAPI() {
          // return one of the platform APIs
          // You can use System.getProperty("os.name") to choose the implementation
       }
    }