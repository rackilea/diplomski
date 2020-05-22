public class TestForThis {

    String name;
    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    class TestForDotThis {
        String name ="in";
        String getName() {
            return TestForThis.this.name;
        }
    }

    public static void main(String[] args) {
        TestForThis t = new TestForThis();
        t.setName("out");
        System.out.println(t.getName());
        TestForThis.TestForDotThis t1 = t.new TestForDotThis();
        System.out.println(t1.getName());
    }
}