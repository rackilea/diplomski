public enum Brand {
    BMW {
        @Override
        public void doSomething();
    },
    AUDI {
        @Override
        public void doSomething();
    };

    public abstract void doSomething();
}

var.getBrand().doSomething();