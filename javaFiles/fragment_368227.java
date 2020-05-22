public class NestedOptional<T> {
    public static <T> Optional<T> fromNullable(Object obj, String... calls) {
        if (obj == null) {
            return Optional.absent();
        }
        for (String call: calls) {
            try {
                obj = obj.getClass().getMethod(call).invoke(obj);
                if (obj == null) {
                    return Optional.absent();
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Couldn't call " + call + "() on " + obj, e);
            }
        }
        return Optional.of(obj);
    }
}