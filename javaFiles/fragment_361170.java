private abstract class A {
    protected final MetaData metaData;

    public A(MetaData metaData) {
        this.metaData = metaData;
    }

    public String getName() {
        return metaData.string;
    }

    public int getAge() {
        return metaData.i;
    }

    public MetaData getMetaData() {
        return metaData;
    }
}

private class B extends A {

    private static final MetaData b = new MetaData("B", 10);
    public B() {
        super(b);
    }
}