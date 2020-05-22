private Object getLock( String str ) {

    Object candidateLock = new Object();
    Object returnedLock = lockMap.putIfAbsent( str, candidateLock );
    return returnedLock == null ? candidateLock : returnedLock;

}