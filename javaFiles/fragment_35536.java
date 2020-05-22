// E - type of elements it can process
// R - the result object type
// K - key type
// K - value type
interface Splitter<E, R, K, V> {

    // A factory method to create the outer of an inner result  
    R newResult();

    // A method to extract a key from the element
    K elementToKey(E element);

    // A method to extract a value from the element
    V elementToValue(E element);

    // A method to split a key to a key group so we can have a nested objects identitied with
    K[] keyToKeyGroup(K key);

    // A method to extract an inner result from existing inner result
    R fromInnerResult(R innerResult, K innerKey);

    // A method to put a key/value pair to the result
    void toInnerResult(R innerResult, K innerKey, V value);

    // A convenience method similar to Collector.of
    static <E, R, K, V> Splitter<E, R, K, V> of(
            final Function<? super E, ? extends K> elementToKey,
            final Function<? super E, ? extends V> elementToValue,
            final Function<? super K, ? extends K[]> keyToKeyGroup,
            final Supplier<? extends R> newResult,
            final BiFunction<? super R, ? super K, ? extends R> fromInnerResult,
            final TriConsumer<? super R, ? super K, ? super V> toInnerResult
    ) {
        return new Splitter<E, R, K, V>() {
            @Override
            public R newResult() {
                return newResult.get();
            }

            @Override
            public K elementToKey(final E element) {
                return elementToKey.apply(element);
            }

            @Override
            public V elementToValue(final E element) {
                return elementToValue.apply(element);
            }

            @Override
            public K[] keyToKeyGroup(final K key) {
                return keyToKeyGroup.apply(key);
            }

            @Override
            public R fromInnerResult(final R innerResult, final K innerKey) {
                return fromInnerResult.apply(innerResult, innerKey);
            }

            @Override
            public void toInnerResult(final R innerResult, final K innerKey, final V value) {
                toInnerResult.accept(innerResult, innerKey, value);
            }
        };
    }

}