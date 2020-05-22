public class ClassB extends ClassA {
    public ClassB() {
       this(StaticUtilityClass.someRandomIntegerValGenerator());
    }

    private ClassB(int x) {
        super(x);
        // Can access x here, e.g.:
        this.x = x;
    }


    private int x;
}