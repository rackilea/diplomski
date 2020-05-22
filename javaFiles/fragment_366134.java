public interface HttpSessionMXBean {

    /**
     * Get HTTP Session id
     */
    public String getSessionId();

    /**
     * Get the date created
     */
    public String getDateCreated();

    /**
     * Get the date created in milliseconds
     */
    public long getMillisCreated();

    /**
     * Get attributes from http session
     *
     * @param attrName Attribute Name
     * @return java.lang.String
     */
    public String getAttribute(String attrName);

    /**
     * Invalidate this session
     */
    public void invalidate();

    /**
     * Unregisters this instance
     */
    public void unregisterThis();
}