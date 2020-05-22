/**
     * Execute a SELECT query that returns a single result.
     * @return the result
     * @throws EntityNotFoundException if there is no result
     * @throws NonUniqueResultException if more than one result
     * @throws IllegalStateException if called for a Java 
     *    Persistence query language UPDATE or DELETE statement
     */
    public Object getSingleResult();