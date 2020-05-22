class A <T extends Serializable> {

        public T someMethod(Class<T> type) {
            Serializable result = someExternalMethod(...);
            return type.cast(result);
        }
    }