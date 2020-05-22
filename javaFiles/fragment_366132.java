public interface SessionsMXBean {

    /**
     * Get Indicates whether the data should be persisted in memory.
     */
    public boolean getPersistData();

    /**
     * Set Indicates whether the data should be persisted in memory.
     */
    public void setPersistData(boolean value);

    /**
     * Get All active sessions that have been persisted.
     */
    public String getActiveSessions();

    /**
     * Get All dates of each active session that has been persisted.
     */
    public String getDatesOfSessions();

    /**
     * Get The threshold for the number of session, after which persistence will
     * take place. If -1 all are persisted.
     */
    public int getSessionsThreshold();

    /**
     * Set The threshold for the number of session, after which persistence will
     * take place. If -1 all are persisted.
     */
    public void setSessionsThreshold(int value);

    /**
     * Set The limit of size to be persisted in KB. If -1 then no size limit.
     */
    public void setPersistenceSize(long value);

    /**
     * Clears all persisted data.
     */
    public void clearData();

    /**
     * Unregisters this instance
     */
    public void unregisterThis();
}