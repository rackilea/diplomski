public static void throwIfFatal(Throwable t) {
    if (t instanceof OnErrorNotImplementedException) {
        throw (OnErrorNotImplementedException) t;
    } else if (t instanceof OnErrorFailedException) {
        throw (OnErrorFailedException) t;
    } else if (t instanceof OnCompletedFailedException) {
        throw (OnCompletedFailedException) t;
    }
    // values here derived from https://github.com/ReactiveX/RxJava/issues/748#issuecomment-32471495
    else if (t instanceof VirtualMachineError) {
        throw (VirtualMachineError) t;
    } else if (t instanceof ThreadDeath) {
        throw (ThreadDeath) t;
    } else if (t instanceof LinkageError) {
        throw (LinkageError) t;
    }
}