public static List<Method> toDict(Class aClass) {
    List<Method> methods = new ArrayList<>();
    do {
        Collections.addAll(methods, aClass.getDeclaredMethods()); //using just this would return the declared methods for the class and not any parent classes
        aClass = aClass.getSuperclass();
    } while (aClass != null);
    return methods;
}