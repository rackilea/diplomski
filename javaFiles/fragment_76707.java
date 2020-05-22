class Foo {
    private String[] bar = <some array contents>;

    public String[] getBar() {
        return bar == null ? bar : Arrays.copyOf(bar);
    }
}