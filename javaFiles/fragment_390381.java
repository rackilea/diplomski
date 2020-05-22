public interface BaseTimestamps {

    /**
     * On create event.
     * used to setup a the creation variable.
     * 
     * @param createdAt
     */
    void setCreatedAt(Date createdAt);

    /**
     * On update event.
     * used to setup a the update variable.
     * 
     * @param updatedAt
     */
    void setUpdatedAt(Date updatedAt);
}