public class ptrace {

    static {
        Native.register(NativeLibrary.getInstance("c"));
    }

    public static native long ptrace(/*enum __ptrace_request*/int request,
            /*pid_t*/ int pid,
            Pointer addr,
            Pointer data) throws LastErrorException;
}