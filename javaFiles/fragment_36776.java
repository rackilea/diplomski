@After
public void writeOutJacocoData() {
    try {
        Class rtClass = Thread.currentThread().getContextClassLoader().getParent().loadClass("org.jacoco.agent.rt.RT");
        Object jacocoAgent = rtClass.getMethod("getAgent", null).invoke(null);
        Method dumpMethod = jacocoAgent.getClass().getMethod("dump", boolean.class);
        dumpMethod.invoke(jacocoAgent, false);
    } catch(ClassNotFoundException e) {
        logger.debug("no jacoco agent attached to this jvm");
    } catch (Exception e) {
        logger.error("while trying to dump jacoco data",e);
    }
}