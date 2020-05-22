public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        if (!e.isShutdown()) {
            Runnable old = e.getQueue().poll();
            if(old instanceof Future<?>) {
                ((Future<?>)old).cancel(true);
            }
            e.execute(r);
        }
    }