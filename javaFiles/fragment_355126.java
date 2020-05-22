private static Object invokeMethods(final String methodString, final Object root) throws Exception {
    final String[] methods = methodString.split("\\.");
    Object result = root;
    for (final String method : methods) {
        result = result.getClass().getMethod(method).invoke(result);
    }
    return result;
}