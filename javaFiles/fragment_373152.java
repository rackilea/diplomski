public void call(Object targetInstance, String methodName, Object... args) {
    Class<?>[] pTypes = new Class<?>[args.length];
    for(int i=0; i < args.length; i++) {
        pTypes[i] = args[i].getClass();
    }
    Method targetMethod = targetInstance.getClass()
              .getMethod(methodName, pTypes);
    targetMethod.invoke(targetInstance, args);
}