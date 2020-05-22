@Override
public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    // Only allow types MultivaluedMap<String, String> and MultivaluedMap.
    return type == MultivaluedMap.class
            && (type == genericType || mapType.equals(genericType));
}