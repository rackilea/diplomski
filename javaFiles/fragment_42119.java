public void rest1(User u) {
    UserTask ut = new UserTask(u);
    pool.put(u.getId(), ut);
    delayPool.put(ut);  // Assuming UserTask implements Delayed with a 5 minute delay
}

public void rest2(User u, Action a) {
    UserTask ut = pool.get(u.getId());
    if(!a.isAccepted() || ut == null)
        pool.remove(u.getId());
    else
        process(ut);

    // Clean up the pool from any expired tasks, can also be done in the beginning
    // of the method, if you want to make sure that expired actions aren't performed
    while((UserTask u = delayPool.poll()) != null)
        pool.remove(u.getId());
}