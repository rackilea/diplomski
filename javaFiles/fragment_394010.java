public static boolean junitIsActive() {     
    for (StackTraceElement s : Thread.currentThread().getStackTrace()) {
        if (s.getClassName().contains("org.junit.runners.model")) {
            return true;
        }
    }       
    return false;
}