/**
 * Matches the execution of any public method in a type with the @{@link CacheEvict}
 * annotation, or any subtype of a type with the {@code CacheEvict} annotation.
 */
private pointcut executionOfAnyPublicMethodInAtCacheEvictType() :
    execution(public * ((@CacheEvict *)+).*(..)) && within(@CacheEvict *);