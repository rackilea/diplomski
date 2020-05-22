public abstract class Super {
    private int id;
    public Super(int id) {
        this.id = id;
    }
    public int getId() { return this.id; }
}

public class Sub extends Super {
    public Sub() {
        super(5); // failure to call this constructor is a compiler error
    }
}