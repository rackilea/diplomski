public boolean add(long userA, long userB, String action) {
    // The put-if-absent ensures the *the same* object but may be violated when:
    //   -users is re-assigned
    //   -following approach is violated
    // A new list is created if needed and the current list is returned if
    // it already exists (as per the method name).
    // Since we have synchronized manually here, these lists
    // themselves do not need to be synchronized, provided:
    // Access should consistently be protected across the "higher"
    // structure (per user-entry in the map) when using this approach.
    List listA = users.putIfAbsent(userA, new List)
    List listB = users.putIfAbsent(userB, new List)
    // The locks must be ordered consistently so that
    // a A B/B A deadlock does not occur.
    Object lock1, lock2
    if (userA < userB) {
        lock1 = listA, lock2 = listB
    } else {
        lock1 = listB, lock2 = listA
    }
    synchronized (lock1) { synchronized (lock2) {{ // start locks

    // The rest of the code can be simplified, since the
    // list items are already *guaranteed* to exist there is no
    // need to alternate between add and creating a new list.
    bool eitherUserBusy = listA.length > 0 || listB.length > 0
    listA.add(action)
    listB.add(action)
    // make sure messages allows thread-safe access as well
    messages.put(action, [userA, userB])
    return !eitherUserBusy

    }} // end locks
}