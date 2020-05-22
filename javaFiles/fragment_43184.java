public class Parent {
    private int bar = 0;
    public void setBar(int value) {
        bar = value;
    }
}

public class Derived extends Parent {
    @override
    public void setBar(int value) {
        bar = value + 1; // NOT ALLOWED
        super.setBar(value + 1); // ALLOWED (same result)
    }
}