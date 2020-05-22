public <T> List<Class<? extends T>> findAllMatchingTypes(Class<T> toFind) {
    foundClasses = new ArrayList<Class<?>>();
    List<Class<? extends T>> returnedClasses = new ArrayList<Class<? extends T>>();
    this.toFind = toFind;
    walkClassPath();
    for (Class<?> clazz : foundClasses) {
        returnedClasses.add((Class<? extends T>) clazz);
    }
    return returnedClasses;
}