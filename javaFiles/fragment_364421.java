import com.google.common.collect.MapMaker;

public static synchronized boolean singleThreaded(Object o) {
    final Thread neu = Thread.currentThread();
    final Thread old = threadMap.put(o, neu);
    return old==null || old==neu;
}

private final static Map<Object, Thread> threadMap =
    new MapMaker().weakKeys().weakValues().makeMap();