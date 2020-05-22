final class Split {

    private Split() {
    }

    static <E, R, K, V> R split(final Iterator<E> iterator, final Splitter<E, R, K, V> splitter) {
        final R outerResult = splitter.newResult();
        while ( iterator.hasNext() ) {
            final E e = iterator.next();
            doSplit(splitter, outerResult, e);
        }
        return outerResult;
    }

    static <E, R, K, V> R split(final Iterable<E> iterable, final Splitter<E, R, K, V> splitter) {
        final R outerResult = splitter.newResult();
        for ( final E e : iterable ) {
            doSplit(splitter, outerResult, e);
        }
        return outerResult;
    }

    static <E, R, K, V> Collector<E, ?, R> asCollector(final Splitter<E, R, K, V> splitter) {
        return Collector.of(
                splitter::newResult,
                (outerResult, e) -> doSplit(splitter, outerResult, e),
                (r1, r2) -> {
                    throw new UnsupportedOperationException();
                },
                Function.identity()
        );
    }

    private static <E, R, K, V> void doSplit(final Splitter<E, R, K, V> splitter, final R outerResult, final E e) {
        final K elementKey = splitter.elementToKey(e);
        final K[] keyGroup = splitter.keyToKeyGroup(elementKey);
        R result = outerResult;
        final int lastI = keyGroup.length - 1;
        for ( int i = 0; i < lastI; i++ ) {
            final K innerKey = keyGroup[i];
            final R candidateInnerResult = splitter.fromInnerResult(result, innerKey);
            if ( candidateInnerResult == null ) {
                final R newTargetResult = splitter.newResult();
                @SuppressWarnings("unchecked")
                final V castNewTargetResult = (V) newTargetResult;
                splitter.toInnerResult(result, innerKey, castNewTargetResult);
                result = newTargetResult;
            } else {
                result = candidateInnerResult;
            }
        }
        final V value = splitter.elementToValue(e);
        splitter.toInnerResult(result, keyGroup[lastI], value);
    }

}