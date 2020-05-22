class MyClass {
    static class MyThreadLocal extends ThreadLocal<Integer> {
        @Override 
        protected Integer initialValue() {
            return 0;
        }
    }
    private ThreadLocal<Integer> dbSwitchCount = new MyThreadLocal();
}