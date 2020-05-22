/**
 * Creates a thread pool that can schedule commands to run after a
 * given delay, or to execute periodically.
 * @param corePoolSize the number of threads to keep in the pool,
 * even if they are idle.
 * @return a newly created scheduled thread pool
 * @throws IllegalArgumentException if {@code corePoolSize < 0}
 */