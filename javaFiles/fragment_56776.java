enum Xyz {
    INSTANCE;

    private final SomeObject abc = new SomeObject();

    public SomeObject method() {
        return abc;
    }
}