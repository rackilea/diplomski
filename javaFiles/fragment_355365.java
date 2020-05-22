@Override
public HashMap<String, String> getSession(String sessionId) {
    Session s = getSessionFromStore(sessionId);
    if (s == null) {
        if (log.isInfoEnabled()) {
            log.info("Session not found " + sessionId);
        }
        return null;
    }

    Enumeration<String> ee = s.getSession().getAttributeNames();
    if (ee == null || !ee.hasMoreElements()) {
        return null;
    }

    HashMap<String, String> map = new HashMap<>();
    while (ee.hasMoreElements()) {
        String attrName = ee.nextElement();
        map.put(attrName, getSessionAttribute(sessionId, attrName));
    }

    return map;

}