/**
 * The time it took the server to make the result available for consumption.
 *
 * @param unit The unit of the duration.
 * @return The time it took for the server to have the result available in the provided time unit.
 */
long resultAvailableAfter( TimeUnit unit );

/**
 * The time it took the server to consume the result.
 *
 * @param unit The unit of the duration.
 * @return The time it took for the server to consume the result in the provided time unit.
 */
long resultConsumedAfter( TimeUnit unit );