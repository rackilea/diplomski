/**
 * Destroying application context. We need to safely stop exporting thread
 * and do cleanup.
 * 
 * @param arg0
 *            reason for cleanup
 */
@Override
public void contextDestroyed(@NotNull ServletContextEvent arg0) {

    // Safely stop exporting service and shut down the application context
    super.contextDestroyed(arg0);

    // Close all JDBC connections
    C3P0Registry.getNumPooledDataSources();
    Iterator<?> it = C3P0Registry.getPooledDataSources().iterator();
    while (it.hasNext()) {
        try {
            PooledDataSource dataSource = (PooledDataSource) it.next();
            dataSource.close();
        } catch (Exception e) {
            log.error("Error when closing connections ...", e);
        }
    }

    // This manually unregisters JDBC drivers, which prevents Tomcat 7 from
    // complaining about memory leaks with this class
    Enumeration<Driver> drivers = DriverManager.getDrivers();
    while (drivers.hasMoreElements()) {
        Driver driver = drivers.nextElement();
        try {
            DriverManager.deregisterDriver(driver);
            log.info(String.format("Unregistering jdbc driver: %s", driver));
        } catch (SQLException e) {
            log.error(
                    String.format("Error deregistering driver %s", driver),
                    e);
        }
    }

    // Waiting for daemon close() c3p0 jdbc pool thread
    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
    for (Thread th : threadSet) {
        if (th.isDaemon()) {
            try {
                if (th.getName().equals(
                        "Resource Destroyer in BasicResourcePool.close()")) {
                    th.join();
                }
            } catch (Exception ex) {
                log.info("Shutdown waiting was interrupted ...");
            }
        }
    }
    // Clear all thread local variables, this prevents Tomcat 7 from
    // complaining about memory leaks
    immolate();

}

/**
 * Cleanup function which cleans all thread local variables. Using thread
 * local variables is not a good practice but unfortunately some libraries
 * are still using them. We need to clean them up to prevent memory leaks.
 * 
 * @return number of Thread local variables
 */
private int immolate() {
    int count = 0;
    try {
        final Field threadLocalsField = Thread.class
                .getDeclaredField("threadLocals");
        threadLocalsField.setAccessible(true);
        final Field inheritableThreadLocalsField = Thread.class
                .getDeclaredField("inheritableThreadLocals");
        inheritableThreadLocalsField.setAccessible(true);
        for (final Thread thread : Thread.getAllStackTraces().keySet()) {
            count += clear(threadLocalsField.get(thread));
            count += clear(inheritableThreadLocalsField.get(thread));
        }
        log.info("Immolated " + count + " values in ThreadLocals");
    } catch (Exception e) {
        log.error("ThreadLocalImmolater.immolate()", e);
    }
    return count;
}

/**
 * Cleaner for thread local map.
 * 
 * @param threadLocalMap
 *            thread local map to clean or null
 * @return number of cleaned objects
 * @throws Exception
 *             in case of error
 */
private int clear(@NotNull final Object threadLocalMap) throws Exception {
    if (threadLocalMap == null) {
        return 0;
    }
    int count = 0;
    final Field tableField = threadLocalMap.getClass().getDeclaredField(
            "table");
    tableField.setAccessible(true);
    final Object table = tableField.get(threadLocalMap);
    for (int i = 0, length = Array.getLength(table); i < length; ++i) {
        final Object entry = Array.get(table, i);
        if (entry != null) {
            final Object threadLocal = ((WeakReference<?>) entry).get();
            if (threadLocal != null) {
                log(i, threadLocal);
                Array.set(table, i, null);
                ++count;
            }
        }
    }
    return count;
}