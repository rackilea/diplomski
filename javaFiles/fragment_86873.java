public Enhancer() {
    this.classPool = newClassPool();
}

public static ClassPool newClassPool() {
    ClassPool classPool = new ClassPool();
    classPool.appendSystemPath();
    classPool.appendClassPath(new LoaderClassPath(Enhancer.class.getClassLoader()));
    classPool.appendClassPath(new ApplicationClassesClasspath());
    return classPool;
}