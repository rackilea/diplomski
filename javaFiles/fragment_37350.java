private static void doMyStuff() {
    Set<Long> myWorkingSet;
    synchronized (workItemsForTasks) {
        myWorkingSet = new HashSet(workItemsForTasks);
        workItemsForTasks.clear();
    }
    for (long x : myWorkingSet) {
        // do something
    }
}