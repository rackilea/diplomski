class Base<T extends Base> {
    private T child;
    private int importantData;

    Base(T child) {
        this.child = child;
    }

    Base() {
        this(null);
    }

    public int sum() {
        if (child != null && child != this) {
            return importantData + child.sum();
        } else {
            return importantData;
        }
    }

    protected T child() {
        return child;
    }

    protected int importantData() {
        return importantData;
    }
}

class Derived extends Base<Derived> {
    private int moreImportant;

    public int convolusion() {
        if (child() != null && child() != this) {
            return moreImportant * importantData() + child().convolusion();
        } else {
            return moreImportant * importantData();
        }
    }
}