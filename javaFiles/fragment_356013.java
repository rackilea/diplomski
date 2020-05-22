int sessionId;

Object callRemote(Object instance, String sMethod, Object... arguments) throws Exception {
    Class<?>[] argumentTypes = createArgumentTypes(arguments);
    Method method = instance.getClass().getMethod(sMethod, argumentTypes );
    Object[] argumentsWithSession = createArguments(arguments);
    return method.invoke(instance, argumentsWithSession);
}

Object[] createArguments(Object[] arguments) {
    Object[] args = new Object[arguments.length + 1];
    System.arraycopy(arguments, 0, args, 0, arguments.length);
    args[arguments.length] = sessionId;
    return args;
}

Class<?>[] createArgumentTypes(Object[] arguments) {
    Class[] types = new Class[arguments.length + 1];
    for (int i = 0; i < arguments.length; i++) {
        types[i] = arguments[i].getClass();
    }
    types[arguments.length] = int.class;
    return types;
}