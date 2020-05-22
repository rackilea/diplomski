public class SomeClass extends SuperClass {
    private SomeClass(int a, int b, int c) {
        super(a, b ,c);
    }

    public static SomeClass create(int a, int b, int c){
        // calculate a for constructor

        return new SomeClass(a, b, c);
    }
}