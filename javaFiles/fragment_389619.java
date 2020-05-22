public class Outer {
    public String out = "out";

    public static class StaticInner {
        public void printEnclosing() {
            System.out.println(Outer.this.out); // Let's say this compiles
        }
    }
}

public class Test {
    public static void main(String[] args) {
        StaticInner si = new StaticInner();
        si.printEnclosing();
    }
}