public class NativeRMISecurityManager extends RMISecurityManager {

    private static final boolean UNIX;

    static {
        String OS = System.getProperty("os.name").toLowerCase();
        UNIX = (OS.compareTo("windows") != 0); /* Assume that if not 
                                                * windows, then "UNIX/POSIX" 
                                                */
    }

    protected static InheritableThreadLocal<String> user =
        new InheritableThreadLocal<String>();

    public static setThreadUser(String username) {
        user.set(username);
    }


    public NativeRMISecurityManager(String initialUser) {
        super();
        // Set the user for the thread that constructs the security manager
        // All threads created as a child of that thread will inherit the user
        // All threads not created as a child of that thread will have a 'null' user
        setThreadUser(initialUser);
    }


    public void checkRead(String file) {
        super.checkRead(file);
        /*
         * If we are on a **IX platform we want to check that 
         * the _user_ has access rights.
         */
        if (UNIX)
        {
            if (file == null)
            {
                throw new SecurityException("file = NULL !!!");
            }

            String str_user = NativeRMISecurityManager.user.get();

            if (str_user != null)
            {
                // Note: sanitize input to native method
                int ret = c_checkRead(file, str_user);

                if (ret != 0)
                {
                    throw new SecurityException("Access error: " + file);
                }
            }

            // Assume a system thread and allow access
        }
    }

    public native int c_checkRead(String file, String user);
}