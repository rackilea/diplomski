Topic topic = null;
SecurityManager prevSecurityManager = System.getSecurityManager();
try {
    System.setSecurityManager(null);
    topic = (Topic) context.lookup(name);
} finally {
    System.setSecurityManager(prevSecurityManager);
}