public void testOptional() throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, InvocationTargetException {
        AtomicReference<ClassA> atomicReference = new AtomicReference<>(new ClassA());
        ClassB classB = new ClassB();

        MyTest myTest = new MyTest(); // here we create the object

        Method method = MyTest.class.getDeclaredMethod("doSomething", AtomicReference.class, ClassB.class);
        method.setAccessible(true);
        method.invoke(myTest, atomicReference, classB); //we invoke doSomething on myTest object with parameters
}