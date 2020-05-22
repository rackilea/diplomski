/**
 * Execute a SELECT query and return the query results
 * as a List.
 * @return a list of the results
 * @throws IllegalStateException if called for a Java 
 *    Persistence query language UPDATE or DELETE statement
 */   
public List getResultList();