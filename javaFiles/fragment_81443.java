public class OverloadedBox {
    //instance variables

    public OverloadedBox() {
        this(0, 0, 0, "nothing");
    }
    public OverloadedBox(int l) {
        this(l, 0, 0, "a line");
    }
    public OverloadedBox(int l, int w) {
        this(l, w, 0, "a rectangle");
    }
    public OverloadedBox(int l, int w, int h) {
        this(l, w, h, "a box");
    }
    private OverloadedBox(int l, int w, int h, String type) {
        System.out.println("Created " + type);
    }
}