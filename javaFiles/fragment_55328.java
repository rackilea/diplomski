public class Demo {
    public static void main(String args[]) {
        Box<String> a = new Box<>();
        a.set("dummy");
        a.whatami();
    }
}

class Box<Integer> {
    private Integer var;

    public void whatami() {
        System.out.println(var.getClass().getName());
    }

    public void set(Integer var) { this.var = var; }
    public Integer get() { return var; }
}