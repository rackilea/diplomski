@SuppressWarnings("unchecked")
private <T, R> Path<R> getPath(Class<R> resultType, Path<T> root, String path) {
    String[] pathElements = path.split("\\.");
    Path<?> retVal = root;
    for (String pathEl : pathElements) {
        retVal = (Path<R>) retVal.get(pathEl);
    }
    return (Path<R>) retVal;
}