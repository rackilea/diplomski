boolean checkRawAssignability(TypeToken<?> assigned, TypeToken<?> from) {

    //if from is a raw type, compare raw types instead
    final Type fromType = from.getType();
    if (fromType instanceof Class<?>) {
        return assigned.getRawType().isAssignableFrom((Class<?>)fromType);
    }

    //otherwise use normal methodology
    return assigned.isAssignableFrom(from);
}