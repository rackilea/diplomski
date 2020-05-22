public static Class<?> type2Class(Type type) {
    if (type instanceof Class) {
       return (Class<?>) type;
    } else if (type instanceof GenericArrayType) {
       // having to create an array instance to get the class is kinda nasty 
       // but apparently this is a current limitation of java-reflection concerning array classes.
       return Array.newInstance(type2Class(((GenericArrayType)type).getGenericComponentType()), 0).getClass(); // E.g. T[] -> T -> Object.class if <T> or Number.class if <T extends Number & Comparable>
    } else if (type instanceof ParameterizedType) {
       return type2Class(((ParameterizedType) type).getRawType()); // Eg. List<T> would return List.class
    } else if (type instanceof TypeVariable) {
       Type[] bounds = ((TypeVariable<?>) type).getBounds();
       return bounds.length == 0 ? Object.class : type2Class(bounds[0]); // erasure is to the left-most bound.
    } else if (type instanceof WildcardType) {
       Type[] bounds = ((WildcardType) type).getUpperBounds();
       return bounds.length == 0 ? Object.class : type2Class(bounds[0]); // erasure is to the left-most upper bound.
    } else { 
       throw new UnsupportedOperationException("cannot handle type class: " + type.getClass());
    }
}