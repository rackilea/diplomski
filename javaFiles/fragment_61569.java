try {
    interfaceClass.getMethod(method.getName(), method.getParameterTypes());
    return true;
} catch (NoSuchMethodException e) {
    return false;
}