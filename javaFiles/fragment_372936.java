public static Map<TypeVariable<?>, Class<?>> findTypeParameterValues(Class<?> cls) {
    Map<TypeVariable<?>, Class<?>> parameterMap = new HashMap<>();
    findTypeParameterValues(parameterMap, cls);     
    return parameterMap;
}

private static void findTypeParameterValues(Map<TypeVariable<?>, Class<?>> map, Class<?> cur) {
    // create list of parameterized super types
    List<ParameterizedType> pTypes = genericSuperTypes(cur)
        .filter(ParameterizedType.class::isInstance)
        .map(ParameterizedType.class::cast)
        .collect(Collectors.toList());

    for(ParameterizedType pType : pTypes) {     
        Type[] tArgs = pType.getActualTypeArguments(); // provided type arguments
        Class<?> rawType = (Class<?>) pType.getRawType(); // (always a Class<?>)
        TypeVariable<?>[] tParams = rawType.getTypeParameters(); // type parameters

        for(int i = 0; i < tArgs.length; i++) { // iterate over both
            Type tArg = tArgs[i]; // match type argument...
            TypeVariable<?> tParam = tParams[i]; // with type parameter
            Class<?> arg; // the value for the parameter
            if(tArg instanceof Class<?>) {
                 // concrete argument
                arg = (Class<?>) tArg;
            } else if(tArg instanceof TypeVariable<?>) {
                 // concrete argument provided previously, or null
                arg = map.get((TypeVariable<?>) tArg);
            } else {
                throw new UnsupportedOperationException("Unsupported type argument type: " + tArg);
            }
            map.put(tParam, arg); // put found value in map
        }
    }

    superClasses(cur).forEach(pt -> findTypeParameterValues(map, pt));
}

private static Stream<Class<?>> superClasses(Class<?> cls) {        
    Stream.Builder<Class<?>> ret = Stream.builder();
    ret.add(cls.getSuperclass());
    Arrays.stream(cls.getInterfaces()).forEach(ret::add);
    return ret.build().filter(Objects::nonNull);
}

private static Stream<Type> genericSuperTypes(Class<?> cls) {
    Stream.Builder<Type> ret = Stream.builder();
    ret.add(cls.getGenericSuperclass());
    Arrays.stream(cls.getGenericInterfaces()).forEach(ret::add);
    return ret.build().filter(Objects::nonNull);
}