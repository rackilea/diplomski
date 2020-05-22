public static void sleepNonBlocking(long millis) {
    Worker.post(new Job() {

        @Override
        public Object run() {
            try {
                Thread.sleep(millis);
            } catch (Exception e) {
                // nothing
            }
            return null;
        }
    });
}