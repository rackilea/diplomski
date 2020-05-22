private final ExecutorService threadPool =
      Executors.newSingleThreadExecutor(/* pass in ThreadFactory to set name */);
...
DBFailoverRecoveryService recoveryService =
       new DBFailoverRecoveryService(this.dbFailoverMutex, this.dataSource);
threadPool.submit(recoveryService);