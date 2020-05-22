BooleanBinding binding = new BooleanBinding() {
    {
        bind(b1, b2, b3);
    }

    @Override
    protected boolean computeValue() {
        if (!b1.get()) {
            return false;
        }
        if (b2.get()) {
            return true;
        } else {
            return b3.get();
        }

        // the above is basically a longer version of

        // return b1.get() && (b2.get() || b3.get());

        // to highlight the short circuiting behaviour
    }
};