/**
 * Scopes a provider. The returned provider returns objects from this scope.
 * If an object does not exist in this scope, the provider can use the given
 * unscoped provider to retrieve one.
 *
 * <p>Scope implementations are strongly encouraged to override
 * {@link Object#toString} in the returned provider and include the backing
 * provider's {@code toString()} output.
 *
 * @param key binding key
 * @param unscoped locates an instance when one doesn't already exist in this
 *  scope.
 * @return a new provider which only delegates to the given unscoped provider
 *  when an instance of the requested object doesn't already exist in this
 *  scope
 */
public <T> Provider<T> scope(Key<T> key, Provider<T> unscoped);