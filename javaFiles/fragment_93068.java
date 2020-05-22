public class Test{
    public static void main(String[] args) {
        A a = new A();
        System.out.println("before mutation:" + a);

        MutableA mutableA = new MutableA(a);
        mutableA.setValue(1);
        System.out.println("before mutation: " + a);
    }
}