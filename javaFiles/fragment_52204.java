public class Set {

    private int maxObjects;
    private int sz;
    private Object[] a;

    public Set(int maxObjects) {
        this.maxObjects = maxObjects;
        this.sz = maxObjects;
        this.a = new Object[maxObjects];
    }

    public Set() {
        this.maxObjects = 100;
        this.sz = 100;
        this.a = new Object[100];
    }

    public void add(Object object) {
        a[0] = object;
    }
}