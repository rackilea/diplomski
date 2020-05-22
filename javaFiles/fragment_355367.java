@Override
protected synchronized void startInternal() throws LifecycleException {

    super.startInternal();

    // Load unloaded sessions, if any
    try {
        load();
    } catch (Throwable t) {
        ExceptionUtils.handleThrowable(t);
        log.error(sm.getString("standardManager.managerLoad"), t);
    }

    setState(LifecycleState.STARTING);
}

@Override
protected synchronized void stopInternal() throws LifecycleException {

    if (log.isDebugEnabled()) {
        log.debug("Stopping");
    }

    setState(LifecycleState.STOPPING);

    // Write out sessions
    try {
        unload();
    } catch (Throwable t) {
        ExceptionUtils.handleThrowable(t);
        log.error(sm.getString("standardManager.managerUnload"), t);
    }

    // Expire all active sessions
    Session sessions[] = findSessions();
    for (int i = 0; i < sessions.length; i++) {
        Session session = sessions[i];
        try {
            if (session.isValid()) {
                session.expire();
            }
        } catch (Throwable t) {
            ExceptionUtils.handleThrowable(t);
        } finally {
            // Measure against memory leaking if references to the session
            // object are kept in a shared field somewhere
            session.recycle();
        }
    }

    // Require a new random number generator if we are restarted
    super.stopInternal();
}