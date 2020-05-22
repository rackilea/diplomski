class Invocable<T> {
        private final T target;
        private final Consumer<T> invocation;

        public Invocable(T target, Consumer<T> invocation) {
            this.target = target;
            this.invocation = invocation;
        }

        public void runInvocation() {
            invocation.accept(target);
        }
    }