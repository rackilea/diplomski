List<MyInterface> list = new ArrayList<>();
for (Class<?> clazz : annotatedClasses) {
    if (MyInterface.class.isAssignableFrom(clazz)) {
        Object instance = clazz.getConstructor().newInstance();
        list.add((MyInterface) instance);
    }
}