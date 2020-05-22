private Class<?> generateDummyClass(String fullQualifedClassName)
        throws IOException, CannotCompileException {

    ClassPool pool = ClassPool.getDefault();
    pool.insertClassPath(new ClassClassPath(this.getClass()));
    CtClass ctClass = pool.makeClass(fullQualifedClassName);
    Class<?> clazz = ctClass.toClass();
    return clazz;
}