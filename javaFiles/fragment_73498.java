class CustomSessionIdGenerator extends StandardSessionIdGenerator{
    @Override
    public String generateSessionId(String route) {
        String sessionId = super(route);
        return sessionId.replace('.',':');
    }
}