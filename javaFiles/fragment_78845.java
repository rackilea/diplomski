public enum Strategies {
    URL {
        @Override
        public void doJob(MyObject mo) {
                // do the work
        }
    },
    ICONS {
        @Override
        public void doJob(MyObject mo) {
                // another work
        }
    };
    public abstract void doJob(MyObject mo);
}