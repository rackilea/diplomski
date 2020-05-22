public static void main(String[] args) {
    try {
        // get a new instance of version 1
        Object newClassInstance1 = m2("com.tima.Helper2", "public String createList() { System.out.println(\"++++\"); return \"200\";}");
        Method method1 = newClassInstance1.getClass().getMethod("createList");

        // this executes the createList in the new class com.tima.Helper2
        String sum1 = (String) method1.invoke(newClassInstance1);
        System.out.println("com.tima.Helper2: " + sum1);

        // this shows that the original Helper method was not modified
        Helper h = new Helper();
        System.out.println("com.tima.Helper: " + h.createList());

        // this shows that the com.tima.Helper2 overrides Helper and can be used as Helper with a modified method
        Helper h2 = (Helper) newClassInstance1;
        System.out.println("com.tima.Helper2 as Helper: " + h2.createList());

        // below does the same thing a second time

        Object newClassInstance2 = m2("com.tima.Helper3", "public String createList() { System.out.println(\"++++\"); return \"300\";}");
        Method method2 = newClassInstance2.getClass().getMethod("createList");
        String sum2 = (String) method2.invoke(newClassInstance2);
        System.out.println("com.tima.Helper3: " + sum2);

        Helper h3 = new Helper();
        System.out.println("com.tima.Helper: " + h3.createList());

        Helper h4 = (Helper) newClassInstance2;
        System.out.println("com.tima.Helper3 as Helper: " + h4.createList());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static Object m2(String className, String methodBody) 
        throws CannotCompileException, InstantiationException, IllegalAccessException, NotFoundException {
    // get the pool
    ClassPool classPool = ClassPool.getDefault();

    // this seems optional, but if it isn't Main.class (my test class) should be replaced with this.getClass()
    classPool.insertClassPath(new ClassClassPath(Main.class));

    // get the helper class
    CtClass helperClass = classPool.get("com.tima.Helper");

    // create a new class
    CtClass newCtClass = classPool.makeClass(className);

    // make it  child of Helper
    newCtClass.setSuperclass(helperClass);

    // this overrides the method in Helper
    newCtClass.addMethod(CtNewMethod.make(methodBody, newCtClass));

    // get a new instance
    Class<?> newClass = newCtClass.toClass();
    Object newClassInstance = newClass.newInstance();

    return newClassInstance;
}