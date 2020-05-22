public class RequestCounter {

        private final AtomicLong addInt = new AtomicLong();
        private final AtomicLong addFailed = new AtomicLong();

        public static long get() {
            return addInt.get();
        }

        public static long add() {
            return addInt.incrementAndGet();
        }

        public static long addFailed(){
            return addFailed.incrementAndGet();
        }
}