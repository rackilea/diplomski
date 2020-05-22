interface GenericSerializer<T> extends Supplier<Serializer> {

    public static GenericSerializer<Long> ofLong() {
        return () -> Serializer.Long;
    }

    ...
}