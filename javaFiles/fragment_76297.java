private static class TransformingClassLoader extends ClassLoader {

    private final String className;

    public TransformingClassLoader(String className) {
        super();
        this.className = className;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals(className)) {
            byte[] byteBuffer = instrumentByteCode(fullyQualifiedSubjectClass);
            return defineClass(className, byteBuffer, 0, byteBuffer.length);
        }
        return super.loadClass(name);
    }
}

@Test
public void testSubject(){
    ClassLoader classLoader = new TransformingClassLoader(fullyQualifiedSubjectClass);
    Class<?> subjectClass = classLoader.loadClass(fullyQualifiedSubjectClass);
    Constructor<?> constructor = subjectClass.getConstructor();
    Object subject = constructor.newInstance();
    Method doSomething = subjectClass.getMethod("doSomething");
    doSomething.invoke(subject);
    Assert.assertTrue(MyClassFileTransformer.wasCalled());
}