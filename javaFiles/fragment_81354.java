// ... standard imports ommitted
import com.sun.management.GarbageCollectionNotificationInfo;

public static void installGCMonitoring() {
    List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
    for (GarbageCollectorMXBean gcBean : gcBeans) {
        NotificationEmitter emitter = (NotificationEmitter) gcBean;
        NotificationListener listener = notificationListener();
        emitter.addNotificationListener(listener, null, null);
    }
}

private static NotificationListener notificationListener() {
    return new NotificationListener() {
        @Override
        public void handleNotification(Notification notification, Object handback) {
            if (notification.getType()
                    .equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)) {
                GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo
                        .from((CompositeData) notification.getUserData());
                String gctype = info.getGcAction();
                if (gctype.contains("major")) {
                    // We are only interested in full (major) GCs
                    Map<String, MemoryUsage> mem = info.getGcInfo().getMemoryUsageAfterGc();
                    for (Entry<String, MemoryUsage> entry : mem.entrySet()) {
                        String memoryPoolName = entry.getKey();
                        MemoryUsage memdetail = entry.getValue();
                        long memMax = memdetail.getMax();
                        long memUsed = memdetail.getUsed();
                        // Use the memMax/memUsed of the pool you are interested in (probably old gen)
                        // to determine memory health.
                    }
                }
            }
        }
    };
}