private boolean hasParameterlessPublicConstructor(Class<?> clazz) {
    for (Constructor<?> constructor : clazz.getConstructors()) {
        // In Java 7-, use getParameterTypes and check the length of the array returned
        if (constructor.getParameterCount() == 0) { 
            return true;
        }
    }
    return false;
}