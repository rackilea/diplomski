public class Runtime {
    private static Runtime currentRuntime = new Runtime();

    /**
     * Returns the runtime object associated with the current Java application.
     * Most of the methods of class <code>Runtime</code> are instance 
     * methods and must be invoked with respect to the current runtime object. 
     * 
     * @return  the <code>Runtime</code> object associated with the current
     *          Java application.
     */
    public static Runtime getRuntime() { 
        return currentRuntime;
    }

    /** Don't let anyone else instantiate this class */
    private Runtime() {}