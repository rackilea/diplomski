yourSession.addSessionStateListener(new SessionStateListener() {
    @Override
    public void onStateChange(SessionState newState, SessionState oldState,
                                          Object source)
    {
        if (newState == SessionState.CLOSED) {
            /* throw away old session and create a new one */
        }
    }
}