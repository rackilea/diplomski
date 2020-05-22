public abstract class Parent {

    private int size;
    private List<String> someList;

    protected Parent(int size) {
        this.size = size;
        someList = new ArrayList<String>(size);
    }

    public int getSize() {
        return size;
    }

}

public class Child extends Parent {
    public Child() {
        super(5);
    }
}