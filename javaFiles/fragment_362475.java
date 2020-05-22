static void someMethod(
        final Map<String, String> mapToUse,
        final SomeClass some
) throws InvocationTargetException, IllegalAccessException {
    // Extract all the methods of SomeClass
    final Method[] methods = some.getClass().getDeclaredMethods();

    for (final Method method : methods) {
        // Consider only methods which are public (setters)
        if (!Modifier.isPublic(method.getModifiers())) {
            continue;
        }

        final String name = method.getName();

        // Check if it is a setter or not
        if (!name.startsWith("set")) {
            continue;
        }

        // Extract the name of the attribute to set (e.g. setAttrib1 -> Attrib1)
        final String[] key = name.split("set");

        // Extract the single argument type of the setter (String, Double, Float, etc.)
        final Class<?> parameterType = method.getParameterTypes()[0];

        // Select the right converter (specified inside FUNCTION_MAP) for the argument type
        final Function<String, Object> converter = FUNCTION_MAP.get(parameterType);

        // Invoke the method, applying the converter on the Map value associated
        // to the attribute name (e.g. key[1] = Attrib1)
        method.invoke(some, converter.apply(mapToUse.get(key[1])));
    }
}