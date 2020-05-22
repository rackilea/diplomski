public Object call(Object bean,
        String methodName,
        Object[] args,
        Class[] parameterTypes,
        UUID sessionId) throws Throwable {

    //find the session
    SessionContext sessionContext = SessionRegistry.getSession(sessionId);
    //set it as current
    SessionRegistry.setLocalSession(sessionContext);
    .....
}