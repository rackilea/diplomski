public static boolean isAspectJAgentLoaded() {
    try {
        org.aspectj.weaver.loadtime.Agent.getInstrumentation();
    } catch (NoClassDefFoundError | UnsupportedOperationException e) {
        System.out.println(e);
        return false;
    }
    return true;
}