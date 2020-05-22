Type returnType = method.getGenericReturnType();

if (returnType instanceof Class<?>) {
    return (Class<?>)returnType;
} else if(returnType instanceof ParameterizedType) {
    return getClass(((ParameterizedType)returnType).getRawType());
}