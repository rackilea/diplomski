for (Method method : someObject.getClass().getDeclaredMethods()) {
    if (Modifier.isPublic(method.getModifiers())
        && method.getParameterTypes().length == 0
        && method.getReturnType() != void.class
        && (method.getName().startsWith("get") || method.getName().startsWith("is"))
    ) {
        Object value = method.invoke(someObject);
        if (value != null) {
            System.out.println(method.getName() + "=" + value);
        }
    }
}