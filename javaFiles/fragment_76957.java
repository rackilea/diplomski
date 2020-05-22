public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
    // check if the class inside the loader can access Callback
    // by analyzing its hierarchy of parent class loaders
    for (ClassLoader curLoader = loader; ; curLoader = curLoader.getParent()) {
        if (curLoader == null) {
            System.out.println("Skip '" + className + "' for " + loader);
            return null;
        } else if (curLoader == Callback.class.getClassLoader())
            break;
    }
    byte[] bytes = instrumentByteCode(classfileBuffer);
    return bytes;
}