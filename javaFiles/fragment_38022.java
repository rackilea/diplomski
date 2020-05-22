public class UnsafeLazyInitialization{ 
    private static SafeStates safeStates;

    public static SafeStates getInstance(){
        if (safeStates == null)
            safeStates = new SafeStates();
        return safeStates;
    }
}