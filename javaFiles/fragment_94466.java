package example.jni;

public class HelloWorld {

    private static final String LIB_SEPARATOR = "\\";
    private static final String LIB_NAME = "Z3GetVersion_Release";
    private static final String LIB_EXT = ".dll";

    /** Placeholder class to ease JNI interaction. */
    public static class IntPtr {
        public int value;
    }

    // this is just to force class loading, and therefore library loading.
    public static void init() { }

    static {
        String curDir = System.getProperty("user.dir");
        try {
            System.load(curDir + LIB_SEPARATOR + LIB_NAME + LIB_EXT);
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Library could not be found in directory:" + curDir );
        } catch (SecurityException e) {
            System.out.println("Security permissions prevented loading library from directory:" + curDir );
        }
    }


    /*private static void getVersion(IntPtr major, IntPtr minor, IntPtr buildNumber, IntPtr revisionNumber)
    {
        major.value=0;
        minor.value=0;
        buildNumber.value=0;
        revisionNumber.value=0;
    }*/   
    private static native void getVersion(IntPtr major, IntPtr minor, IntPtr buildNumber, IntPtr revisionNumber);

    public static String z3VersionString() {
        IntPtr major = new IntPtr();
        IntPtr minor = new IntPtr();
        IntPtr buildNumber = new IntPtr();
        IntPtr revisionNumber = new IntPtr();
        getVersion(major, minor, buildNumber, revisionNumber);
        return "Z3 " + major.value + "." + minor.value + " (build " + buildNumber.value + ", rev. " + revisionNumber.value + ")";
    }

    public static void main(String[] args) {
        System.out.println(z3VersionString());
    }
}