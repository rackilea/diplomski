class BeanTest {
    String name;

    protected BeanTest(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}