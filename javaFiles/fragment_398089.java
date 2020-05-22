Object testClass = Class.forName("com.example.TestClass").newInstance();
for (Class<?> cls : testClass.getClass().getDeclaredClasses()) {
    // You would like to exclude static nested classes 
    // since they require another approach.
    if (!Modifier.isStatic(cls.getModifiers())) {
        Object innerClass = cls
            .getDeclaredConstructor(new Class[] { testClass.getClass() })
            .newInstance(new Object[] { testClass });
    }
}