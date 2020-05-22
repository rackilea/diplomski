// do our own thread local resources which close when we want.
Map<Thread, Resource> threadLocalMap = new ConcurrentHashMap<>();

fj.submit(
() -> myStream.parallel().forEach(e -> {
     Resource r = threadLocalMap.computeIfAbsent(Thread.currentThread(), t -> new Resource();
    // use the thread local autocloseable here, 
})

// later once all the tasks have finished.
// close all the thread local resources when the parallel processing is done
threadLocalMap.values().forEach(Utils::closeQuietly);