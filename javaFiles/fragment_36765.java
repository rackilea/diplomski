public static boolean isAspectJAgentLoaded() {
    try {
        Class<?> agentClass = Class.forName("org.aspectj.weaver.loadtime.Agent");
        Method method = agentClass.getMethod("getInstrumentation");
        method.invoke(null);
    } catch (Exception e) {
        //System.out.println(e);
        return false;
    }
    return true;
}