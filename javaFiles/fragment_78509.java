public Set<Thread> findThreadsRunningClass(Class classToFindRunning) {

  Set<Thread> runningThreads = new HashSet<Thread>();
  String className = classToFindRunning.getName();

  Map<Thread,StackTraceElement[]> stackTraces = Thread.getAllStackTraces();
  for(Thread t : stackTraces.keySey()) {
    StackTraceElement[] steArray = stackTraces.get(t);
    for(int i = 0;i<steArray.size();i++) {
      StackTraceElement ste = steArray[i];
      if(ste.getClassName().equals(className)) {
        runningThreads.add(t);
        continue;
      }
    }
  }

  return runningThreads;
}