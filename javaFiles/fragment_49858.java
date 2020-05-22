@SuppressWarnings("deprecation")
    private void clearReferencesThreads() {
        Thread[] threads = getThreads();

    // Iterate over the set of threads
    for (Thread thread : threads) {
        if (thread != null) {
            ClassLoader ccl = thread.getContextClassLoader();
            if (ccl == this) {
                // Don't warn about this thread
                if (thread == Thread.currentThread()) {
                    continue;
                }

                // JVM controlled threads
                ThreadGroup tg = thread.getThreadGroup();
                if (tg != null &&
                        JVM_THREAD_GROUP_NAMES.contains(tg.getName())) {

                    // HttpClient keep-alive threads
                    if (clearReferencesHttpClientKeepAliveThread &&
                            thread.getName().equals("Keep-Alive-Timer")) {
                        thread.setContextClassLoader(parent);
                        log.debug(sm.getString(
                                "webappClassLoader.checkThreadsHttpClient"));
                    }

                    // Don't warn about remaining JVM controlled threads
                    continue;
                }

                // Skip threads that have already died
                if (!thread.isAlive()) {
                    continue;
                }

                // TimerThread can be stopped safely so treat separately
                if (thread.getClass().getName().equals(
                        "java.util.TimerThread") &&
                        clearReferencesStopTimerThreads) {
                    clearReferencesStopTimerThread(thread);
                    continue;
                }

                if (isRequestThread(thread)) {
                    log.error(sm.getString("webappClassLoader.warnRequestThread",
                            contextName, thread.getName()));
                } else {
                    log.error(sm.getString("webappClassLoader.warnThread",
                            contextName, thread.getName()));
                }

                // Don't try an stop the threads unless explicitly
                // configured to do so
                if (!clearReferencesStopThreads) {
                    continue;
                }

                // If the thread has been started via an executor, try
                // shutting down the executor
                try {
                    Field targetField =
                        thread.getClass().getDeclaredField("target");
                    targetField.setAccessible(true);
                    Object target = targetField.get(thread);

                    if (target != null &&
                            target.getClass().getCanonicalName().equals(
                            "java.util.concurrent.ThreadPoolExecutor.Worker")) {
                        Field executorField =
                            target.getClass().getDeclaredField("this$0");
                        executorField.setAccessible(true);
                        Object executor = executorField.get(target);
                        if (executor instanceof ThreadPoolExecutor) {
                            ((ThreadPoolExecutor) executor).shutdownNow();
                        }
                    }
                } catch (SecurityException e) {
                    log.warn(sm.getString(
                            "webappClassLoader.stopThreadFail",
                            thread.getName(), contextName), e);
                } catch (NoSuchFieldException e) {
                    log.warn(sm.getString(
                            "webappClassLoader.stopThreadFail",
                            thread.getName(), contextName), e);
                } catch (IllegalArgumentException e) {
                    log.warn(sm.getString(
                            "webappClassLoader.stopThreadFail",
                            thread.getName(), contextName), e);
                } catch (IllegalAccessException e) {
                    log.warn(sm.getString(
                            "webappClassLoader.stopThreadFail",
                            thread.getName(), contextName), e);
                }

                // This method is deprecated and for good reason. This is
                // very risky code but is the only option at this point.
                // A *very* good reason for apps to do this clean-up
                // themselves.
                thread.stop();
            }
        }
    }
}