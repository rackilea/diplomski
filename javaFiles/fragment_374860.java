public class Throttler {
    ...
    public static class Factory {
        @Inject
        public class Factory(... Throttler dependencies ...) {...}
        public Throttler create(int maxRequestsPerSec) {
            return new Throttler(maxRequestsPerSec /*, injected Throttler dependencies */);
        }
    }
}