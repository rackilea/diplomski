class SessionUtil {
    private ThreadLocal currentSession;

    public Session getCurrentSession() {
        if(currentSession.get() == null) {
             Session s = //create new session
             currentSession.set(s);
        }
        return (Session)currentSession.get();
    }
}