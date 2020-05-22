/**
 * Find documents using a declarative JSON querying syntax.
 * @param <T> The class type.
 * @param jsonQuery The JSON query string.
 * @param classOfT The class of type T.
 * @return The result of the query as a {@code List<T> }
 * @throws CouchDbException If the query failed to execute or the request is invalid.
 */
public <T> List<T> findDocs(String jsonQuery, Class<T> classOfT) { ...