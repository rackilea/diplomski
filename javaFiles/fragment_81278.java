class Base {
    static enum Option {
        alpha, beta, gamma;
    }

    public Base(Option o) {
        // ...
    }
}

class Derived extends Base {
    public Derived(String s) {
        super(Option.valueOf(s));
    }
}