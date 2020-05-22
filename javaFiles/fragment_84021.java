private static Map<String, Class<? extends MyInterface>> buildOptions() {
    Map<String, Class<? extends MyInterface>> options = new HashMap<>();
    for (Class<?> cls : MyStuff.class.getDeclaredClasses()) {
        if (MyInterface.class.isAssignableFrom(cls)) {
            options.put(cls.getSimpleName(), cls.asSubclass(MyInterface.class));
        }
    }
    return Collections.unmodifiableMap(options); // Make it immutable
}