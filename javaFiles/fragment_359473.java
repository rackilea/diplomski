class Option<T> {

    ...

    public static final class Functions {

        //Impl note: Effective Java item 27
        private static final Function<?, ?> GET_REFERENCED_OBJECT =
                new Function<Option<?>, Object>() {
                    @Override
                    public Object apply(Option<?> option) {
                        return option.getReferencedObject();
                    }
                };

        private Functions() { }

        public static <T> Function<Option<T>, T> getReferencedObject() {
            //okay for any T, since Option<T>.getReferencedObject must return a T
            @SuppressWarnings("unchecked")
            final Function<Option<T>, T> withNarrowedTypes =
                    (Function<Option<T>, T>)GET_REFERENCED_OBJECT;
            return withNarrowedTypes;
        }
    }
}