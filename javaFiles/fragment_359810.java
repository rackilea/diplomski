Map<Integer, Runnable> methodMap = new ConcurrentHashMap<>();
methodMap.put(1, () -> doMethod1());
methodMap.put(2, () -> doMethod2());
methodMap.put(3, () -> doMethod3());
// ... and so on ...

// look up the method and run it:
Runnable method = methodMap.get(code);
if (method != null) {
    method.run();
}