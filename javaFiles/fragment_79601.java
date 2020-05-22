/**
 * Finds all the collections in this database.
 *
 * @param resultClass the class to decode each document into
 * @param <TResult>   the target document type of the iterable.
 * @return the list collections iterable interface
 * @mongodb.driver.manual reference/command/listCollections listCollections
 */
<TResult> ListCollectionsIterable<TResult> listCollections(Class<TResult> resultClass);