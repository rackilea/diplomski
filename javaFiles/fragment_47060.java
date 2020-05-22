@FunctionalInterface
interface CopyFunction<T> {
    T apply(T source, T result) throws Exception;
}

public static <T> CopyFunction<T> createCopyFunction(Class<T> type) {
    return (source, result) -> {
        for (Field field : getListOfFields(type)) {
            field.set(result, field.get(source));
        }
        return result;
    };
}