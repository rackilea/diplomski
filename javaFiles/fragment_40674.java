private IJavaType[] getExceptionTypes(Class<?>[] declaredExceptions) {
    IJavaType[] exceptions = new IJavaType[declaredExceptions.length];

    for (int i = 0; i < declaredExceptions.length; i++) {
        exceptions[i] = getType(declaredExceptions[i]);
    }

    return exceptions;
}

protected IJavaType[] getExceptionTypes(Method method) {
    return getExceptionTypes(method.getExceptionTypes());
}

protected IJavaType[] getExceptionTypes(Constructor<?> c) {
    return getExceptionTypes(c.getExceptionTypes());
}