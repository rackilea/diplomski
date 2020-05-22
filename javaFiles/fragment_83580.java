/**
 * Given an Iterator `inner`, returns a new Iterator which will emit items upon
 * request, but throttled to at most one item every `minDelayMs` milliseconds.
 */
public static <T> Iterator<T> throttledIterator(Iterator<T> inner, int minDelayMs) {
    return new Iterator<T>() {
        private long lastEmittedMillis = System.currentTimeMillis() - minDelayMs;

        @Override
        public boolean hasNext() {
            return inner.hasNext();
        }

        @Override
        public T next() {
            long now = System.currentTimeMillis();
            long requiredDelayMs = now - lastEmittedMillis;
            if (requiredDelayMs > 0) {
                try {
                    Thread.sleep(requiredDelayMs);
                } catch (InterruptedException e) {
                    // resume
                }
            }
            lastEmittedMillis = now;

            return inner.next();
        }
    };
}