Set<Object> knownDeadlocks = ConcurrentHashMap.newKeySet();
// ...
Future<?> deadlockListener = scope.getScheduler().schedule(() ->
{
    if (knownDeadlocks.add(Throwables.getStackTraceAsString(context)))
        log.warn("Possible deadlock", context);
}, DEADLOCK_DURATION.toMillis(), TimeUnit.MILLISECONDS);