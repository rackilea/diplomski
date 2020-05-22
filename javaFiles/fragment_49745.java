@Override
public Object invoke(Object proxy, Method method, Object[] args) {
    System.out.println(method.getDeclaringClass().getSimpleName()
        + "." + method.getName()
        + Arrays.toString(method.getParameterTypes())
        + ": " + (method.getAnnotation(C.class) != null ? "C" : "null"));
    return null;
}