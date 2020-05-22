@Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState,
                            Object[] previousState, String[] propertyNames, Type[] types) {




    /**
     * Update the lastUpdateDate value and set the wasUpdated flag to 'Y'
     */
    if (entity instanceof TimeStamped) {


        int indexOfLastUpdate = ArrayUtils.indexOf(propertyNames, "lastUpdatedDate");
        int indexOfCreatedDate = ArrayUtils.indexOf(propertyNames, "createdDate");
        int indexOfWasUpdated = ArrayUtils.indexOf(propertyNames, "wasUpdated");

        Date createdDate = (Date) previousState[indexOfCreatedDate];
        Date lastUpdateDate = (Date) currentState[indexOfLastUpdate];


        /**
         * If createdDate equals lastUpdateDate, this is the first update.
         * Set the updated column to Y
         */
        if (createdDate.equals(lastUpdateDate)) {
            logger.warning("This is the first update of the record.");
            currentState[indexOfWasUpdated] = 'Y';
        }
        // set the new date of the update event
        currentState[indexOfLastUpdate] = new Date();


        return true;
    }
    return false;
}